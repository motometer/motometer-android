package ua.com.motometer.android.core.facade.api

import ua.com.motometer.android.core.facade.api.model.ExpenseRecord

interface ExpenseFacade {
    fun expenses(): List<ExpenseRecord>
}