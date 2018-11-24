package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.State

data class RecordCreated(val fuelRecord: ExpenseRecord) : State {
    override fun changeState(action: Action): State = Home
}