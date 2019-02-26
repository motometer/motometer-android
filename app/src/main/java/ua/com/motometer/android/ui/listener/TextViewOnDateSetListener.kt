package ua.com.motometer.android.ui.listener

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import android.widget.TextView
import java.time.LocalDate

class TextViewOnDateSetListener(private val view: TextView) : DatePickerDialog.OnDateSetListener {
    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val localDate = LocalDate.of(year, month, dayOfMonth)
        view.text = localDate.toString()
        view.tag = localDate
        Log.d(javaClass.simpleName, "Chosen date $localDate")
    }
}