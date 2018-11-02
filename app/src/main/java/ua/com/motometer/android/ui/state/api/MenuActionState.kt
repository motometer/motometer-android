package ua.com.motometer.android.ui.state.api

interface MenuActionState : State {

    fun changeState(action: Actions.Menu): State {
        return when (action) {
            is Actions.Menu.Home -> this.changeState(action)
            is Actions.Menu.Garage -> this.changeState(action)
            is Actions.Menu.SignOut -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Menu.Home): State

    fun changeState(action: Actions.Menu.Garage): State

    fun changeState(action: Actions.Menu.SignOut): State
}