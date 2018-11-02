package ua.com.motometer.android.ui.state

object Home : MenuState, CommonActionState, MenuActionState {
    override fun changeState(action: Action): State {
        return when (action) {
            is Actions.Common -> this.changeState(action)
            is Actions.Menu -> this.changeState(action)
            is Actions.Home.AddNewRecord -> AddRecordState
            else -> this
        }
    }

    override fun changeState(action: Actions.Common.Back): State = ClosedApp

    override fun changeState(action: Actions.Common.OpenMenu): State = Menu(this)

    override fun changeState(action: Actions.Common.CloseMenu): State = this

    override fun changeState(action: Actions.Menu.Home): State = Home

    override fun changeState(action: Actions.Menu.Garage): State = Garage

    override fun changeState(action: Actions.Menu.SignOut): State = SignOut

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleHome(this)
}