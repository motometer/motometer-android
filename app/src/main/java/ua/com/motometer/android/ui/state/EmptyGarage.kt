package ua.com.motometer.android.ui.state

class EmptyGarage : MenuState {
    override fun changeState(action: Action): State {
        return when (logAction(action)) {
            is Actions.Common.OpenMenu -> Menu(this)
            is Actions.Common.Back -> Garage()
            is Actions.Garage.Add -> NewVehicle()
            is Actions.Garage.Empty -> this
            is Actions.Menu.Garage -> Garage()
            else -> throw IllegalArgumentException("Unsupported action $action")
        }
    }

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleGarage(Garage())
}