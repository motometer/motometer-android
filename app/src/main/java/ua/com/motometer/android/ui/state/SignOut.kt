package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.MenuHandler
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State

object SignOut : MenuState {
    override fun changeState(action: Action): State {
        logAction(action)
        return this
    }

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleSignOut(this)
}