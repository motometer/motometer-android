package ua.com.motometer.android.ui.adapter

import android.support.annotation.IdRes
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.View
import ua.com.motometer.android.ui.state.Actions
import ua.com.motometer.android.ui.state.ActionListener

class DrawerListenerAdapter(
        @IdRes private val selectedItem: Int,
        private val original: DrawerLayout.DrawerListener,
        private val actionListener: ActionListener) : DrawerLayout.DrawerListener by original {

    override fun onDrawerSlide(view: View, p1: Float) {
        if (view is NavigationView) {
            view.setCheckedItem(selectedItem)
        }
        original.onDrawerSlide(view, p1)
    }

    override fun onDrawerOpened(view: View) {
        original.onDrawerOpened(view)
        actionListener.onAction(Actions.Common.OpenMenu)
    }
}