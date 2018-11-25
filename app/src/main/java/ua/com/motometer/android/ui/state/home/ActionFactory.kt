package ua.com.motometer.android.ui.state.home

import android.view.View
import android.widget.TextView
import ua.com.motometer.android.ui.state.api.Action

interface ActionFactory {
    fun toAction(view: View): Action

    fun extractText(view: TextView?): String {
        return view?.text.toString()
    }
}