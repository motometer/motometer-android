package ua.com.motometer.android.ui.state.api

import ua.com.motometer.android.ui.state.MenuClosed
import ua.com.motometer.android.ui.state.MenuOpened

interface CommonActionState : State {

    fun changeState(action: Actions.Common): State {
        return when (action) {
            is Actions.Common.Back -> this.changeState(action)
            is Actions.Common.CloseMenu -> this.changeState(action)
            is Actions.Common.OpenMenu -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Common.Back): State

    fun changeState(action: Actions.Common.OpenMenu): State = MenuOpened(this)

    fun changeState(action: Actions.Common.CloseMenu): State = MenuClosed(this)
}