package ua.com.motometer.android.ui.menu

import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout

abstract class BaseMenuAction(private val drawerLayout: DrawerLayout) : Function0<Boolean> {
    override fun invoke(): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}