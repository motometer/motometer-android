package ua.com.motometer.android.core.facade.impl

import ua.com.motometer.android.core.facade.api.ExpenseFacade
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord
import java.util.ArrayList

class DummyExpenseFacade : ExpenseFacade {

    override fun expenses(): List<ExpenseRecord> {
        return list
    }

    override fun addExpense(expenseRecord: ExpenseRecord) {
        list.add(expenseRecord)
    }

    companion object {
        private val list: MutableList<ExpenseRecord> = ArrayList()
    }
}