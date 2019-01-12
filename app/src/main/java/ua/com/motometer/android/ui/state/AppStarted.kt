package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.State

data class AppStarted(private val nextState: State) : State {
    override fun changeState(action: Action): State = nextState
}