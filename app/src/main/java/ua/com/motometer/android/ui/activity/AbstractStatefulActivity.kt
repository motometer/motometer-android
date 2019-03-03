package ua.com.motometer.android.ui.activity

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.State
import ua.com.motometer.android.ui.state.api.StatefulView
import kotlin.properties.Delegates

abstract class AbstractStatefulActivity(initialState: State) : AppCompatActivity(), StatefulView, ActionListener {

    private var currentState: State by Delegates.observable(initialState) { _, old, new ->
        renderViewState(old, new)
    }

    override fun renderViewState(oldState: State, newState: State) {
        Log.d(javaClass.simpleName, "Changing state from $oldState to $newState")
    }

    override fun onBackPressed() = onAction(Actions.Common.Back)

    override fun onAction(action: Action) {
        currentState = currentState.changeState(action)
    }
}