package ua.com.motometer.android.ui.state.home

import android.view.View
import android.widget.TextView
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import java.time.LocalDate

class FuelRecordFactory : ActionFactory {
    override fun toAction(view: View): Action {
        val serviceDate = view.findViewById<TextView>(R.id.date)
        val petrolStationName = view.findViewById<TextView>(R.id.petrol_station_name)
        val fuelPrice = view.findViewById<TextView>(R.id.fuel_price)
        val fuelRefilled = view.findViewById<TextView>(R.id.fuel_refilled)
        val fuelTotalAmount = view.findViewById<TextView>(R.id.amount)
        val serviceOdometer = view.findViewById<TextView>(R.id.odometer)
        val serviceComment = view.findViewById<TextView>(R.id.comment)

        return ImmutableFuelRecord.builder()
                .comment(extractText(serviceComment))
                .date(LocalDate.parse(extractText(serviceDate)))
                .petrolStationName(extractText(petrolStationName))
                .fuelPrice(extractText(fuelPrice).toBigDecimal())
                .fuelRefilled(extractText(fuelRefilled).toBigDecimal())
                .amount(extractText(fuelTotalAmount).toBigDecimal())
                .odometer(extractText(serviceOdometer).toInt())
                .build()
                .let { Actions.Home.SubmitFuel(it) }
    }
}