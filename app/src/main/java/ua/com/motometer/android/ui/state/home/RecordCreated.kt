package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.core.facade.api.model.Record
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.State

open class RecordCreated<T : Record>(open val record: T) : State {
    override fun changeState(action: Action): State = Home
}