package ua.com.motometer.android.ui.state.home

import android.os.AsyncTask
import android.view.View
import android.widget.TextView
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import java.time.LocalDate

class OnSubmitRecordListener(val view: View, private val actionListener: ActionListener) : View.OnClickListener {
    override fun onClick(button: View?) {
        AsyncTask.execute {
            val serviceDate = view.findViewById<TextView>(R.id.service_date)
            val petrol_station_name = view.findViewById<TextView>(R.id.petrol_station_name)
            val fuel_price = view.findViewById<TextView>(R.id.fuel_price)
            val fuel_refilled = view.findViewById<TextView>(R.id.fuel_refilled)
            val fuel_total_amount = view.findViewById<TextView>(R.id.fuel_total_amount)
            val service_odometer = view.findViewById<TextView>(R.id.service_odometer)
            val service_comment = view.findViewById<TextView>(R.id.service_comment)

            val fuelRecord = ImmutableFuelRecord.builder()
                    .comment(extractText(service_comment))
                    .date(LocalDate.parse(extractText(serviceDate)))
                    .petrolStationName(extractText(petrol_station_name))
                    .fuelPrice(extractText(fuel_price).toBigDecimal())
                    .fuelRefilled(extractText(fuel_refilled).toBigDecimal())
                    .fuelTotalAmount(extractText(fuel_total_amount).toBigDecimal())
                    .odometer(extractText(service_odometer).toInt())
                    .build()

            actionListener.onAction(Actions.Home.SubmitRecord(fuelRecord))
        }
    }

    private fun extractText(view: TextView?): String {
        return view?.text.toString()
    }
}