package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.GarageActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.MenuHandler
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State

object EmptyGarage : MenuState, CommonActionState, MenuActionState, GarageActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> this.changeState(action)
            is Actions.Menu -> this.changeState(action)
            is Actions.Garage -> this.changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Common.Back): State = Garage

    override fun changeState(action: Actions.Garage.Add): State = NewVehicle

    override fun changeState(action: Actions.Garage.VehicleDetails): State = this

    override fun changeState(action: Actions.Garage.Empty): State = this

    override fun changeState(action: Actions.Garage.FinishCreate): State = this

    override fun changeState(action: Actions.Garage.Cancel): State = this

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleGarage(Garage)
}