package ua.com.motometer.android.core.facade.impl

import ua.com.motometer.android.core.dao.Record
import ua.com.motometer.android.core.dao.RecordDao
import ua.com.motometer.android.core.facade.api.ExpenseFacade
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord
import ua.com.motometer.android.core.facade.api.model.FuelRecord
import ua.com.motometer.android.core.facade.api.model.ImmutableExpenseRecord
import ua.com.motometer.android.core.facade.api.model.ServiceRecord
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

class RoomExpenseFacade(private val recordDao: RecordDao) : ExpenseFacade {

    override fun expenses(): List<ExpenseRecord> {
        return recordDao.findAll().map {
            ImmutableExpenseRecord.of(
                    BigDecimal(it.amount),
                    LocalDate.parse(it.date),
                    it.comment

            )
        }
    }

    override fun addRecord(record: FuelRecord) {
        record.let {
            recordDao.insert(Record(
                    UUID.randomUUID().toString(),
                    record.odometer(),
                    record.amount().toDouble(),
                    record.comment(),
                    record.date().toString()
            ))
        }
    }

    override fun addRecord(record: ServiceRecord) {
        record.let {
            recordDao.insert(Record(
                    UUID.randomUUID().toString(),
                    record.odometer(),
                    record.amount().toDouble(),
                    record.comment(),
                    record.date().toString()
            ))
        }
    }
}