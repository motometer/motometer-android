package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.State

data class VehicleDetails(val vehicleId: Long) : CommonActionState, MenuActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Common -> this.changeState(action)
            is Actions.Menu -> this.changeState(action)
            else -> Garage()
        }
    }

    override fun changeState(action: Actions.Common.Back): State = Garage()
}