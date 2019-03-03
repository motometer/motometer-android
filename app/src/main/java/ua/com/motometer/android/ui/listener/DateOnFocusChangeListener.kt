package ua.com.motometer.android.ui.listener

import androidx.fragment.app.FragmentActivity
import android.view.View
import android.widget.EditText

class DateOnFocusChangeListener(private val activity: FragmentActivity) : View.OnFocusChangeListener {
    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        view as EditText
        if (hasFocus) {
            val newFragment = ua.com.motometer.android.ui.fragment.common.DatePickerDialog()
            newFragment.listener = TextViewOnDateSetListener(view)
            newFragment.show(activity.supportFragmentManager, "datePicker")
        }
    }
}