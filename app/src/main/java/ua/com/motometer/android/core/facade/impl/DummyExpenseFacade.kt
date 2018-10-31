package ua.com.motometer.android.core.facade.impl

import ua.com.motometer.android.core.facade.api.ExpenseFacade
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord
import ua.com.motometer.android.core.facade.api.model.ImmutableExpenseRecord
import java.math.BigDecimal
import java.time.LocalDate
import java.util.ArrayList

class DummyExpenseFacade : ExpenseFacade {
    private val list: MutableList<ExpenseRecord> = ArrayList()

    init {
        for (i in 1..25) {
            val position = i.toLong()
            addItem(ImmutableExpenseRecord.of(position, BigDecimal("201.1"), LocalDate.now(), "TO: № $position"))
        }
    }

    override fun expenses(): List<ExpenseRecord> {
        return list
    }

    private fun addItem(item: ExpenseRecord) {
        list.add(item)
    }

    data class DummyItem(val id: String, val date: String, val amount: Int, val comment: String) {
        override fun toString(): String = "$amount $ | $comment |$date"
    }
}