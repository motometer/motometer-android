package ua.com.motometer.android.ui.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_garage.*
import kotlinx.android.synthetic.main.app_bar_garage.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.ui.garage.GarageListFragment
import ua.com.motometer.android.ui.garage.NewVehicleFragment
import ua.com.motometer.android.ui.menu.createListener

class GarageActivity : AbstractMenuActivity(), GarageListFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .replace(R.id.garage_list, NewVehicleFragment())
                    .commit()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().run {
                replace(R.id.garage_list, GarageListFragment())
                commit()
            }
        }
        nav_view.setNavigationItemSelectedListener(createListener(drawer_layout, this))
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onListFragmentInteraction(item: Vehicle?) {

    }
}
