package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.State

object VehicleChoice : State {
    override fun changeState(action: Action): State = RecordTypeChoice
}