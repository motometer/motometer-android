package ua.com.motometer.android.ui.adapter

import android.support.v4.widget.DrawerLayout
import android.view.View
import ua.com.motometer.android.ui.state.Actions
import ua.com.motometer.android.ui.state.ActionListener

class DrawerListenerAdapter(private val original: DrawerLayout.DrawerListener,
                            private val actionListener: ActionListener) : DrawerLayout.DrawerListener by original {

    override fun onDrawerOpened(view: View) {
        original.onDrawerOpened(view)
        actionListener.onAction(Actions.Common.OpenMenu)
    }
}