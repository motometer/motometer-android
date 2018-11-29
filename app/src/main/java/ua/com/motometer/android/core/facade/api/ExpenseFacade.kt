package ua.com.motometer.android.core.facade.api

import ua.com.motometer.android.core.facade.api.model.ExpenseRecord
import ua.com.motometer.android.core.facade.api.model.FuelRecord
import ua.com.motometer.android.core.facade.api.model.ServiceRecord

interface ExpenseFacade {
    fun expenses(): List<ExpenseRecord>

    fun addRecord(record: FuelRecord)

    fun addRecord(record: ServiceRecord)
}