package ua.com.motometer.android.ui.state

class Menu(private val previousState: State) : State {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> common(action)
            is Actions.Menu -> menu(action)
            else -> this
        }
    }

    private fun common(action: Actions.Common): State {
        return when(action) {
            is Actions.Common.Back -> previousState
            is Actions.Common.CloseMenu -> previousState
            is Actions.Common.OpenMenu -> this
        }
    }

    private fun menu(action: Actions.Menu): State {
        return when (action) {
            is Actions.Menu.Home -> Home()
            is Actions.Menu.Garage -> Garage()
            is Actions.Menu.SignOut -> SignOut()
        }
    }
}