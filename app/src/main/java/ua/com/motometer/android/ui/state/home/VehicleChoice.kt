package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.State
import ua.com.motometer.android.ui.state.logAction

object VehicleChoice : CommonActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> this.changeState(action)
            else -> RecordTypeChoice
        }
    }

    override fun changeState(action: Actions.Common.Back): State = Home
}