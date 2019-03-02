package ua.com.motometer.android.ui.activity

import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_garage.*
import kotlinx.android.synthetic.main.app_bar_garage.*
import kotlinx.android.synthetic.main.fragment_new_vehicle.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.VehicleRepository
import ua.com.motometer.android.core.facade.api.model.ImmutableVehicle
import ua.com.motometer.android.core.firebase.FirebaseModule
import ua.com.motometer.android.ui.adapter.DrawerListenerAdapter
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.adapter.OnNavigationItemSelectedListenerAdapter
import ua.com.motometer.android.ui.fragment.garage.EmptyGarageFragment
import ua.com.motometer.android.ui.fragment.garage.ListFragment
import ua.com.motometer.android.ui.fragment.garage.NewVehicleFragment
import ua.com.motometer.android.ui.fragment.garage.VehicleDetailsFragment
import ua.com.motometer.android.ui.state.AppClosed
import ua.com.motometer.android.ui.state.AppStarted
import ua.com.motometer.android.ui.state.Garage
import ua.com.motometer.android.ui.state.MenuClosed
import ua.com.motometer.android.ui.state.MenuOpened
import ua.com.motometer.android.ui.state.NewVehicle
import ua.com.motometer.android.ui.state.NewVehicleCreated
import ua.com.motometer.android.ui.state.VehicleDetails
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State
import ua.com.motometer.android.ui.state.home.Home
import java.time.LocalDate
import javax.inject.Inject

class GarageActivity : AbstractMenuActivity(AppStarted(Garage())) {

    @Inject
    lateinit var vehicleRepository: VehicleRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)
        setSupportActionBar(toolbar)
        DaggerActivityComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(application))
                .firebaseModule(FirebaseModule())
                .build()
                .inject(this)

        fab.setOnClickListener(OnClickListenerAdapter(Actions.Garage.Add, this))

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(DrawerListenerAdapter(R.id.nav_garage, toggle, this))
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(OnNavigationItemSelectedListenerAdapter(this))
        onAction(Actions.Menu.Garage)
    }

    override fun renderViewState(oldState: State, newState: State) {
        super.renderViewState(oldState, newState)
        if (oldState == newState) {
            return
        }
        when (newState) {
            is Garage -> handleGarage(newState)
            is NewVehicle -> showNewVehicle()
            is AppClosed -> finishAffinity()
            is MenuState -> newState.handleMenu(this)
            is MenuOpened -> Unit
            is MenuClosed -> menuClosed()
            is NewVehicleCreated -> AsyncTask.execute {
                addNewVehicle()
            }
            is VehicleDetails -> showVehicleDetails(newState)
            else -> Log.e(javaClass.simpleName, "Illegal state $newState")
        }
    }

    private fun addNewVehicle() {
        ImmutableVehicle.builder()
                .manufacturer(text(R.id.new_vehicle_manufacturer_edit))
                .model(text(R.id.new_vehicle_model_edit))
                .builtYear(text(R.id.new_vehicle_build_year_edit).toInt())
                .registrationNumber(text(R.id.new_vehicle_reg_num_edit))
                .boughtDate(findViewById<EditText>(R.id.new_vehicle_bought_date_edit).tag as LocalDate)
                .type(new_vehicle_type_choice.selectedItem.toString())
                .price(text(R.id.new_vehicle_price_edit).toBigDecimal())
                .currency(text(R.id.new_vehicle_currency_edit))
                .id(0)
                .build()
                .let(vehicleRepository::registerVehicle)

        onAction(Actions.Menu.Garage)
    }

    private fun showVehicleDetails(newState: VehicleDetails) {
        supportFragmentManager.beginTransaction().run {
            val fragment = VehicleDetailsFragment()

            val bundle = Bundle()
            bundle.putLong("vehicleId", newState.vehicleId)
            fragment.arguments = bundle

            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

            replace(R.id.garage_list, fragment)
            commit()
        }
    }

    private fun text(viewId: Int) = findViewById<EditText>(viewId).text.toString()

    private fun showEmptyGarage() {
        supportFragmentManager.beginTransaction().run {
            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            replace(R.id.garage_list, EmptyGarageFragment())
            commit()
        }
    }

    override fun handleHome(state: Home) = finish()

    override fun handleGarage(state: Garage) {
        if (state.empty) {
            showEmptyGarage()
        } else {
            supportFragmentManager.beginTransaction().run {
                setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                replace(R.id.garage_list, ListFragment())
                commit()
            }
        }
    }

    override fun drawerLayout(): DrawerLayout = drawer_layout

    private fun showNewVehicle() {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.garage_list, NewVehicleFragment())
                .commit()
    }
}
