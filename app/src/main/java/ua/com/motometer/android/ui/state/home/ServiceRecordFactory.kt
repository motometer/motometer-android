package ua.com.motometer.android.ui.state.home

import android.view.View
import android.widget.TextView
import ua.com.motometer.android.R
import java.time.LocalDate

class ServiceRecordFactory : ExpenseRecordFactory {
    override fun createExpenseRecord(view: View): ServiceRecord {
        val serviceDate = view.findViewById<TextView>(R.id.date)
        val amount = view.findViewById<TextView>(R.id.amount)
        val odometer = view.findViewById<TextView>(R.id.odometer)
        val comment = view.findViewById<TextView>(R.id.comment)

        return ImmutableServiceRecord.builder()
                .comment(extractText(comment))
                .date(LocalDate.parse(extractText(serviceDate)))
                .amount(extractText(amount).toBigDecimal())
                .odometer(extractText(odometer).toInt())
                .build()
    }
}