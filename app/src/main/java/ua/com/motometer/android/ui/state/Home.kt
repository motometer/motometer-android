package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.HomeActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.MenuHandler
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State

object Home : MenuState, CommonActionState, MenuActionState, HomeActionState {
    override fun changeState(action: Action): State {
        return when (action) {
            is Actions.Common -> this.changeState(action)
            is Actions.Menu -> this.changeState(action)
            is Actions.Home -> this.changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Common.Back): State = ClosedApp

    override fun changeState(action: Actions.Common.OpenMenu): State = Menu(this)

    override fun changeState(action: Actions.Common.CloseMenu): State = this

    override fun changeState(action: Actions.Menu.Home): State = Home

    override fun changeState(action: Actions.Menu.Garage): State = Garage

    override fun changeState(action: Actions.Menu.SignOut): State = SignOut

    override fun changeState(action: Actions.Home.AddNewRecord): State = AddRecordState

    override fun changeState(action: Actions.Home.TrackRecordDetails): State = this

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleHome(this)
}