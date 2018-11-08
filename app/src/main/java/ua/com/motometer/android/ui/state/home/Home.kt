package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.ui.state.AppClosed
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.HomeActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.MenuHandler
import ua.com.motometer.android.ui.state.api.MenuState
import ua.com.motometer.android.ui.state.api.State
import ua.com.motometer.android.ui.state.logAction

object Home : MenuState, CommonActionState, MenuActionState, HomeActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> this.changeState(action)
            is Actions.Menu -> this.changeState(action)
            is Actions.Home -> this.changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Common.Back): State = AppClosed

    override fun changeState(action: Actions.Home.AddNewRecord): State = VehicleChoice

    override fun changeState(action: Actions.Home.TrackRecordDetails): State = this

    override fun handleMenu(menuHandler: MenuHandler) = menuHandler.handleHome(this)

    override fun changeState(action: Actions.Home.RecordTypeChoice): State = this

    override fun changeState(action: Actions.Home.RecordTypeDialogClosed): State = this

    override fun changeState(action: Actions.Home.SubmitRecord): State = this

    override fun changeState(action: Actions.Home.ChoseRecord): State = this
}