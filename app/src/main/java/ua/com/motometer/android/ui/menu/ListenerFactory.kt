package ua.com.motometer.android.ui.menu

import android.content.Context
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import ua.com.motometer.android.R

fun createListener(drawerLayout: DrawerLayout, context: Context): NavigationView.OnNavigationItemSelectedListener {
    val actionMap = mapOf(
            Pair(R.id.sign_out, SignOutAction(drawerLayout, context)),
            Pair(R.id.nav_garage, OpenGarageAction(drawerLayout, context))
    )
    return ActionMapListener(actionMap) {
        drawerLayout.closeDrawer(GravityCompat.START)
        return@ActionMapListener true
    }
}
