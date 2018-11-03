package ua.com.motometer.android.ui.state.api

import ua.com.motometer.android.ui.state.Garage
import ua.com.motometer.android.ui.state.Home
import ua.com.motometer.android.ui.state.SignOut

interface MenuActionState : State {

    fun changeState(action: Actions.Menu): State {
        return when (action) {
            is Actions.Menu.Home -> this.changeState(action)
            is Actions.Menu.Garage -> this.changeState(action)
            is Actions.Menu.SignOut -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Menu.Home): State = Home

    fun changeState(action: Actions.Menu.Garage): State = Garage()

    fun changeState(action: Actions.Menu.SignOut): State = SignOut
}