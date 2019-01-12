package ua.com.motometer.android.ui.activity

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.ExpenseFacade
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.firebase.FirebaseModule
import ua.com.motometer.android.ui.adapter.DrawerListenerAdapter
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.adapter.OnNavigationItemSelectedListenerAdapter
import ua.com.motometer.android.ui.fragment.home.NewRecordFragment
import ua.com.motometer.android.ui.fragment.home.RecordListFragment
import ua.com.motometer.android.ui.fragment.home.RecordTypeChoiceDialog
import ua.com.motometer.android.ui.fragment.home.VehicleChoiceDialog
import ua.com.motometer.android.ui.state.AppClosed
import ua.com.motometer.android.ui.state.AppStarted
import ua.com.motometer.android.ui.state.Garage
import ua.com.motometer.android.ui.state.MenuClosed
import ua.com.motometer.android.ui.state.MenuOpened
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State
import ua.com.motometer.android.ui.state.home.FuelRecordCreated
import ua.com.motometer.android.ui.state.home.Home
import ua.com.motometer.android.ui.state.home.NewRecord
import ua.com.motometer.android.ui.state.home.RecordTypeChoice
import ua.com.motometer.android.ui.state.home.ServiceRecordCreated
import ua.com.motometer.android.ui.state.home.VehicleChoice
import javax.inject.Inject

class HomeActivity : AbstractMenuActivity(AppStarted(Home)) {

    @Inject
    lateinit var expenseFacade: ExpenseFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        DaggerActivityComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(application))
                .firebaseModule(FirebaseModule())
                .build()
                .inject(this)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(DrawerListenerAdapter(R.id.nav_home, toggle, this))
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(OnNavigationItemSelectedListenerAdapter(this))
        fab.setOnClickListener(OnClickListenerAdapter(Actions.Home.AddNewRecord, this))
        onAction(Actions.Menu.Home)
    }

    override fun onResume() {
        super.onResume()
        onAction(Actions.Menu.Home)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun renderViewState(oldState: State, newState: State) {
        super.renderViewState(oldState, newState)
        if (oldState == newState) {
            return
        }
        when (newState) {
            is Home -> home()
            is RecordTypeChoice -> recordTypeChoice()
            is VehicleChoice -> vehicleChoice()
            is NewRecord -> newRecord(newState)
            is FuelRecordCreated -> recordCreated(newState)
            is ServiceRecordCreated -> recordCreated(newState)
            is MenuOpened -> Unit
            is MenuClosed -> menuClosed()
            is AppClosed -> finishAffinity()
            is MenuState -> newState.handleMenu(this)
            else -> Log.e(javaClass.simpleName, "Illegal state $newState")
        }
    }

    private fun recordCreated(recordCreated: FuelRecordCreated) {
        AsyncTask.execute {
            expenseFacade.addRecord(recordCreated.record)
            onAction(Actions.Menu.Home)
        }
    }

    private fun recordCreated(recordCreated: ServiceRecordCreated) {
        AsyncTask.execute {
            expenseFacade.addRecord(recordCreated.record)
            onAction(Actions.Menu.Home)
        }
    }

    private fun vehicleChoice() {
        val dialog = VehicleChoiceDialog()
        dialog.show(supportFragmentManager, "VehicleChoiceDialog")
    }

    private fun newRecord(newRecordState: NewRecord) {
        val ordinal = newRecordState.recordType.ordinal

        supportFragmentManager.beginTransaction().run {
            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            val bundle = Bundle()
            bundle.putInt(NewRecordFragment.RECORD_TYPE, ordinal)
            val fragment = NewRecordFragment()
            fragment.arguments = bundle
            replace(R.id.record_list, fragment)
            commit()
        }
    }

    private fun recordTypeChoice() {
        val dialog = RecordTypeChoiceDialog()
        dialog.show(supportFragmentManager, "RecordTypeChoiceDialog")
    }

    private fun home() {
        supportFragmentManager.beginTransaction().run {
            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            replace(R.id.record_list, RecordListFragment())
            commit()
        }
    }

    override fun handleHome(state: Home) = finishAffinity()

    override fun handleGarage(state: Garage) {
        startActivity(Intent(this, GarageActivity::class.java))
    }

    override fun drawerLayout(): DrawerLayout = drawer_layout
}
