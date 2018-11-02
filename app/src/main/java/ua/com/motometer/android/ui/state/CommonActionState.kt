package ua.com.motometer.android.ui.state

interface CommonActionState : State {

    fun changeState(action: Actions.Common): State {
        return when (action) {
            is Actions.Common.Back -> this.changeState(action)
            is Actions.Common.CloseMenu -> this.changeState(action)
            is Actions.Common.OpenMenu -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Common.Back): State

    fun changeState(action: Actions.Common.OpenMenu): State

    fun changeState(action: Actions.Common.CloseMenu): State
}