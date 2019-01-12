package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.core.facade.api.model.ServiceRecord

data class ServiceRecordCreated(override val record: ServiceRecord) : RecordCreated<ServiceRecord>(record)