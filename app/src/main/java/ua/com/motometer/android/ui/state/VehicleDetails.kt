package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.State

data class VehicleDetails(val vehicleId: Long) : State {
    override fun changeState(action: Action): State {
        return when (action) {
            is Actions.Common.Back -> Garage
            else -> Garage
        }
    }
}