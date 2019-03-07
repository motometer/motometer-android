package ua.com.motometer.android.core.facade.api

import io.reactivex.Single
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord
import ua.com.motometer.android.core.facade.api.model.FuelRecord
import ua.com.motometer.android.core.facade.api.model.ServiceRecord

interface ExpenseRepository {
    fun expenses(): Single<List<ExpenseRecord>>

    fun addRecord(record: FuelRecord)

    fun addRecord(record: ServiceRecord)
}