package ua.com.motometer.android.ui.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import kotlinx.android.synthetic.main.activity_garage.*
import kotlinx.android.synthetic.main.app_bar_garage.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.ui.fragment.garage.ListFragment
import ua.com.motometer.android.ui.fragment.garage.NewVehicleFragment
import ua.com.motometer.android.ui.adapter.DrawerListenerAdapter
import ua.com.motometer.android.ui.adapter.OnNavigationItemSelectedListenerAdapter
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.state.Actions
import ua.com.motometer.android.ui.state.CloseApp
import ua.com.motometer.android.ui.state.Garage
import ua.com.motometer.android.ui.state.Home
import ua.com.motometer.android.ui.state.MenuState
import ua.com.motometer.android.ui.state.NewVehicle
import ua.com.motometer.android.ui.state.State

class GarageActivity : AbstractMenuActivity(Garage()), ListFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)
        setSupportActionBar(toolbar)

        fab.setOnClickListener(OnClickListenerAdapter(Actions.Garage.Add, this))

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(DrawerListenerAdapter(toggle, this))
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(OnNavigationItemSelectedListenerAdapter(this))
        onAction(Actions.Menu.Garage)
    }

    override fun onListFragmentInteraction(item: Vehicle?) {

    }

    override fun renderViewState(oldState: State, newState: State) {
        when (newState) {
            is NewVehicle -> showNewVehicle()
            is CloseApp -> finishAffinity()
            is MenuState -> newState.handleMenu(this)
            else -> Log.e(javaClass.simpleName, "Illegal state $newState")
        }
    }

    override fun handleHome(state: Home) = finish()

    override fun handleGarage(state: Garage) {
        drawer_layout.closeDrawer(GravityCompat.START)
        supportFragmentManager.beginTransaction().run {
                setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            replace(R.id.garage_list, ListFragment())
            commit()
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
