package ua.com.motometer.android.ui.state.home

import android.os.AsyncTask
import android.view.View
import ua.com.motometer.android.ui.state.api.ActionListener

class OnSubmitRecordListener(
        val view: View,
        private val actionListener: ActionListener,
        private val actionFactory: ActionFactory) : View.OnClickListener {
    override fun onClick(button: View?) {
        AsyncTask.execute {
            actionFactory.toAction(view)
                    .let(actionListener::onAction)
        }
    }
}