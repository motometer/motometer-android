package ua.com.motometer.android.ui.adapter

import android.support.design.widget.NavigationView
import android.view.MenuItem
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.state.ActionListener
import ua.com.motometer.android.ui.state.Actions

class OnNavigationItemSelectedListenerAdapter(private val actionListener: ActionListener) : NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(view: MenuItem): Boolean {
        actionListener.onAction(toAction(view))
        return true
    }

    private fun toAction(p0: MenuItem): Actions {
        return when (p0.itemId) {
            R.id.sign_out -> Actions.Menu.Garage
            R.id.nav_garage -> Actions.Menu.Garage
            else -> Actions.Common.CloseMenu
        }
    }
}