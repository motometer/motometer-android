package ua.com.motometer.android.core.facade.impl

import ua.com.motometer.android.core.facade.api.ExpenseFacade
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord
import ua.com.motometer.android.core.facade.api.model.FuelRecord
import ua.com.motometer.android.core.facade.api.model.ImmutableExpenseRecord
import ua.com.motometer.android.core.facade.api.model.ServiceRecord
import java.util.ArrayList

class DummyExpenseFacade : ExpenseFacade {

    override fun expenses(): List<ExpenseRecord> {
        return list
    }

    override fun addRecord(record: FuelRecord) {
        list.add(record.let {
            ImmutableExpenseRecord.of(0,
                    it.amount(), it.date(), it.comment()
            )
        })
    }

    override fun addRecord(record: ServiceRecord) {
        list.add(record.let {
            ImmutableExpenseRecord.of(1,
                    it.amount(), it.date(), it.comment()
            )
        })
    }

    companion object {
        private val list: MutableList<ExpenseRecord> = ArrayList()
    }
}