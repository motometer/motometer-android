package ua.com.motometer.android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.adapter.DrawerListenerAdapter
import ua.com.motometer.android.ui.adapter.OnNavigationItemSelectedListenerAdapter
import ua.com.motometer.android.ui.state.Garage
import ua.com.motometer.android.ui.state.Home
import ua.com.motometer.android.ui.state.Menu
import ua.com.motometer.android.ui.state.MenuState
import ua.com.motometer.android.ui.state.State

class HomeActivity : AbstractMenuActivity(Home()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(DrawerListenerAdapter(toggle, this))
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(OnNavigationItemSelectedListenerAdapter(this))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun renderViewState(oldState: State, newState: State) {
        when (newState) {
            is Home -> drawer_layout.closeDrawer(GravityCompat.START)
            is Menu -> Unit
            is MenuState -> newState.handleMenu(this)
            else -> Log.e(javaClass.simpleName, "Illegal state $newState")
        }
    }

    override fun handleHome(state: Home) = finishAffinity()

    override fun handleGarage(state: Garage) {
        drawerLayout().closeDrawer(GravityCompat.START)
        startActivity(Intent(this, GarageActivity::class.java))
    }

    override fun drawerLayout(): DrawerLayout = drawer_layout
}
