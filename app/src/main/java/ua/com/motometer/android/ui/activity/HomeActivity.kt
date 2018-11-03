package ua.com.motometer.android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.adapter.DrawerListenerAdapter
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.adapter.OnNavigationItemSelectedListenerAdapter
import ua.com.motometer.android.ui.fragment.home.NewRecordFragment
import ua.com.motometer.android.ui.fragment.home.RecordListFragment
import ua.com.motometer.android.ui.state.AddRecord
import ua.com.motometer.android.ui.state.AppClosed
import ua.com.motometer.android.ui.state.Garage
import ua.com.motometer.android.ui.state.Home
import ua.com.motometer.android.ui.state.Menu
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State

class HomeActivity : AbstractMenuActivity(Home) {

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
        drawer_layout.addDrawerListener(DrawerListenerAdapter(R.id.nav_home, toggle, this))
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(OnNavigationItemSelectedListenerAdapter(this))
        fab.setOnClickListener(OnClickListenerAdapter(Actions.Home.AddNewRecord, this))
        onAction(Actions.Menu.Home)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun renderViewState(oldState: State, newState: State) {
        when (newState) {
            is Home -> home()
            is AddRecord -> addRecord()
            is Menu -> onMenu(newState)
            is AppClosed -> finishAffinity()
            is MenuState -> newState.handleMenu(this)
            else -> Log.e(javaClass.simpleName, "Illegal state $newState")
        }
    }

    private fun addRecord() {
        supportFragmentManager.beginTransaction().run {
            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            replace(R.id.record_list, NewRecordFragment())
            commit()
        }
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
