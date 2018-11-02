package ua.com.motometer.android.ui.state

object Garage : MenuState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common.OpenMenu -> Menu(this)
            is Actions.Common.Back -> Home
            is Actions.Garage.Add -> NewVehicle
            is Actions.Garage.VehicleDetails -> VehicleDetails(action.vehicleId)
            is Actions.Garage.Empty -> EmptyGarage
            else -> this
        }
    }

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleGarage(this)
}