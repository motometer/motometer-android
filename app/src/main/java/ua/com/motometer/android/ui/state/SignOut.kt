package ua.com.motometer.android.ui.state

object SignOut : MenuState {
    override fun changeState(action: Action): State = this

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleSignOut(this)
}