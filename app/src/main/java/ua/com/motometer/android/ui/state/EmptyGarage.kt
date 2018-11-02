package ua.com.motometer.android.ui.state

object EmptyGarage : MenuState, CommonActionState, MenuActionState {
    override fun changeState(action: Action): State {
        return when (action) {
            is Actions.Common -> this.changeState(action)
            is Actions.Menu -> this.changeState(action)
            is Actions.Garage.Add -> NewVehicle
            is Actions.Garage.Empty -> this
            else -> this
        }
    }

    override fun changeState(action: Actions.Common.Back): State = Garage

    override fun changeState(action: Actions.Common.OpenMenu): State = Menu(this)

    override fun changeState(action: Actions.Common.CloseMenu): State = this

    override fun changeState(action: Actions.Menu.Home): State = Home

    override fun changeState(action: Actions.Menu.Garage): State = Garage

    override fun changeState(action: Actions.Menu.SignOut): State = SignOut

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleGarage(Garage)
}