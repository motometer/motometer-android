package ua.com.motometer.android.ui.state

data class Menu(private val previousState: State) : CommonActionState, MenuActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> changeState(action)
            is Actions.Menu -> changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Common.Back): State = previousState

    override fun changeState(action: Actions.Common.OpenMenu): State = this

    override fun changeState(action: Actions.Common.CloseMenu): State = previousState

    override fun changeState(action: Actions.Menu.Home): State = Home

    override fun changeState(action: Actions.Menu.Garage): State = Garage

    override fun changeState(action: Actions.Menu.SignOut): State = SignOut
}