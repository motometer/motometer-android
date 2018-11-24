package ua.com.motometer.android.ui.state.home

import android.os.AsyncTask
import android.view.View
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions

class OnSubmitRecordListener(
        val view: View,
        private val actionListener: ActionListener,
        private val expenseRecordFactory: ExpenseRecordFactory) : View.OnClickListener {
    override fun onClick(button: View?) {
        AsyncTask.execute {
            expenseRecordFactory.createExpenseRecord(view)
                    .let { Actions.Home.SubmitRecord(it) }
                    .let(actionListener::onAction)
        }
    }
}