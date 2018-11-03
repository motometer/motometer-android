package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.HomeActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.State

object AddRecord : MenuActionState, CommonActionState, HomeActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Menu -> this.changeState(action)
            is Actions.Common -> this.changeState(action)
            is Actions.Home -> this.changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Home.AddNewRecord): State = this

    override fun changeState(action: Actions.Home.TrackRecordDetails): State = this

    override fun changeState(action: Actions.Common.Back): State = Home
}