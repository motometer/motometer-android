package ua.com.motometer.android.ui.adapter

import android.view.View
import ua.com.motometer.android.ui.state.Action
import ua.com.motometer.android.ui.state.ActionListener

class OnClickListenerAdapter(val action: Action, private val actionListener: ActionListener) : View.OnClickListener {
    override fun onClick(p0: View?) = actionListener.onAction(action)
}