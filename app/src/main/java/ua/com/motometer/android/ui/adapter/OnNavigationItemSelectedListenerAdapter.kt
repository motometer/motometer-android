package ua.com.motometer.android.ui.adapter

import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions

class OnNavigationItemSelectedListenerAdapter(private val actionListener: ActionListener) : NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(view: MenuItem): Boolean {
        actionListener.onAction(toAction(view))
        return true
    }

    private fun toAction(p0: MenuItem): Actions {
        return when (p0.itemId) {
            R.id.nav_garage -> Actions.Menu.Garage
            R.id.nav_home -> Actions.Menu.Home
            R.id.sign_out -> Actions.Menu.SignOut
            else -> Actions.Common.CloseMenu
        }
    }
}