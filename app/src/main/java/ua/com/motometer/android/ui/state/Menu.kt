package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.State

data class Menu(private val previousState: State, val opened: Boolean = true) : CommonActionState, MenuActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> changeState(action)
            is Actions.Menu -> changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Common.Back): State {
        return if (opened) Menu(previousState, false) else previousState
    }
}