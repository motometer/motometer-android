package ua.com.motometer.android.ui.state.api

import ua.com.motometer.android.ui.state.Menu

interface CommonActionState : State {

    fun changeState(action: Actions.Common): State {
        return when (action) {
            is Actions.Common.Back -> this.changeState(action)
            is Actions.Common.CloseMenu -> this.changeState(action)
            is Actions.Common.OpenMenu -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Common.Back): State

    fun changeState(action: Actions.Common.OpenMenu): State = Menu(this)

    fun changeState(action: Actions.Common.CloseMenu): State = this
}