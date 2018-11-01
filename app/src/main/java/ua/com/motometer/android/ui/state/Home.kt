package ua.com.motometer.android.ui.state

class Home : MenuState {
    override fun changeState(action: Action): State {
        return when (logAction(action)) {
            is Actions.Common.OpenMenu -> Menu(this)
            is Actions.Common.Back -> CloseApp()
            is Actions.Home.AddNewRecord -> AddRecordState()
            else -> this
        }
    }

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleHome(this)
}