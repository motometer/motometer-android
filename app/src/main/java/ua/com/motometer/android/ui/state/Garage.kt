package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.GarageActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.MenuHandler
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State

object Garage : MenuState, MenuActionState, CommonActionState, GarageActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> this.changeState(action)
            is Actions.Garage -> this.changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Menu.Home): State = Home

    override fun changeState(action: Actions.Menu.Garage): State = Garage

    override fun changeState(action: Actions.Menu.SignOut): State = SignOut

    override fun changeState(action: Actions.Common.Back): State = Home

    override fun changeState(action: Actions.Common.OpenMenu): State = Menu(this)

    override fun changeState(action: Actions.Common.CloseMenu): State = this

    override fun changeState(action: Actions.Garage.Add): State = NewVehicle

    override fun changeState(action: Actions.Garage.VehicleDetails): State = VehicleDetails(action.vehicleId)

    override fun changeState(action: Actions.Garage.Empty): State = EmptyGarage

    override fun changeState(action: Actions.Garage.FinishCreate): State = this

    override fun changeState(action: Actions.Garage.Cancel): State = this

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleGarage(this)
}