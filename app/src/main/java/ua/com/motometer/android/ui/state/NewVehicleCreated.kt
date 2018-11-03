package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.State

object NewVehicleCreated : State {
    override fun changeState(action: Action): State {
        logAction(action)
        return Garage()
    }
}