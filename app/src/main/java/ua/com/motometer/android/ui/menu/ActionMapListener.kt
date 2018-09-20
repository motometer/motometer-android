package ua.com.motometer.android.ui.menu

import android.support.design.widget.NavigationView
import android.view.MenuItem

internal class ActionMapListener(private val actionMap: Map<Int, Function0<Boolean>>,
                                 private val defaultAction: Function0<Boolean>
) : NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return actionMap.getOrDefault(item.itemId, defaultAction).invoke()
    }
}