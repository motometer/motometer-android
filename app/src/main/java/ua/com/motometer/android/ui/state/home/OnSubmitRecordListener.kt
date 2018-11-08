package ua.com.motometer.android.ui.state.home

import android.os.AsyncTask
import android.view.View
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions

class OnSubmitRecordListener(val view: View, private val actionListener: ActionListener) : View.OnClickListener {
    override fun onClick(button: View?) {
        AsyncTask.execute {
            val serviceDate = view.findViewById<View>(R.id.service_date)
            val petrol_station_name = view.findViewById<View>(R.id.petrol_station_name)
            val fuel_price = view.findViewById<View>(R.id.fuel_price)
            val fuel_refilled = view.findViewById<View>(R.id.fuel_refilled)
            val fuel_total_amount = view.findViewById<View>(R.id.fuel_total_amount)
            val service_odometer = view.findViewById<View>(R.id.service_odometer)
            val service_comment = view.findViewById<View>(R.id.service_comment)
        }

        actionListener.onAction(Actions.Home.ChoseRecord)
    }
}