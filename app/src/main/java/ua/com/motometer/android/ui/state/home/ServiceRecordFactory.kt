package ua.com.motometer.android.ui.state.home

import android.view.View
import android.widget.TextView
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.model.ImmutableServiceRecord
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import java.time.LocalDate

class ServiceRecordFactory : ActionFactory {
    override fun toAction(view: View): Action {
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
                .let { Actions.Home.SubmitService(it) }
    }
}