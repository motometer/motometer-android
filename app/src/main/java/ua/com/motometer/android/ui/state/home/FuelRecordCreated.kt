package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.core.facade.api.model.FuelRecord

data class FuelRecordCreated(override val record: FuelRecord) : RecordCreated<FuelRecord>(record)