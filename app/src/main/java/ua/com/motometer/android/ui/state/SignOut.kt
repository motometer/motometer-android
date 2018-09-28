package ua.com.motometer.android.ui.state

class SignOut : MenuState {
    override fun changeState(action: Action): State = this

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleSignOut(this)
}