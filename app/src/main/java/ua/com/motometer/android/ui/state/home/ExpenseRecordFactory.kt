package ua.com.motometer.android.ui.state.home

import android.view.View
import android.widget.TextView

interface ExpenseRecordFactory {
    fun createExpenseRecord(view: View): ExpenseRecord

    fun extractText(view: TextView?): String {
        return view?.text.toString()
    }
}