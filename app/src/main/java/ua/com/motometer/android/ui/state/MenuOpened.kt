package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.State

data class MenuOpened(val previousState: State) : CommonActionState, MenuActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        if (action is Actions.Common.DrawerClosed) {
            return this.changeState(action)
        }
        return MenuClosed(
                when (action) {
                    is Actions.Common -> changeState(action)
                    is Actions.Menu -> changeState(action)
                    else -> this
                }
        )
    }

    override fun changeState(action: Actions.Common.Back): State = previousState

    override fun changeState(action: Actions.Common.DrawerClosed): State = previousState
}