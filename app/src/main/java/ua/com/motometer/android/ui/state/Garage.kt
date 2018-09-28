package ua.com.motometer.android.ui.state

class Garage : MenuState {
    override fun changeState(action: Action): State {
        return when (logAction(action)) {
            is Actions.Common.OpenMenu -> Menu(this)
            is Actions.Common.Back -> Home()
            is Actions.Garage.Add -> NewVehicle()
            is Actions.Menu.Garage -> this
            else -> throw IllegalArgumentException("Unsupported action $action")
        }
    }

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleGarage(this)
}