package ua.com.motometer.android.ui.activity

import android.support.v7.app.AppCompatActivity
import ua.com.motometer.android.ui.state.Action
import ua.com.motometer.android.ui.state.Actions
import ua.com.motometer.android.ui.state.ActionListener
import ua.com.motometer.android.ui.state.State
import ua.com.motometer.android.ui.state.StatefulView
import kotlin.properties.Delegates

abstract class AbstractStatefulActivity(initialState: State) : AppCompatActivity(), StatefulView, ActionListener {

    private var currentState: State by Delegates.observable(initialState) { _, old, new ->
        renderViewState(old, new)
    }

    override fun onBackPressed() = onAction(Actions.Common.Back)

    override fun onAction(action: Action) {
        currentState = currentState.changeState(action)
    }
}