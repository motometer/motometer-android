package ua.com.motometer.android.ui.fragment.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import android.view.View
import kotlinx.android.synthetic.main.record_type_choice.view.*
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.home.RecordType

class RecordTypeChoiceDialog : DialogFragment() {

    private lateinit var actionListener: ActionListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val activity = activity!!
        actionListener = actionListener(activity)

        val inflater = activity.layoutInflater

        val view = inflater.inflate(R.layout.record_type_choice, null)
        val builder = AlertDialog.Builder(activity)
                .setMessage("Choose record type")
                .setView(view)

        val closeListener = View.OnClickListener { this@RecordTypeChoiceDialog.dismiss() }

        view.record_type_fuel.setOnClickListener(onClickListener(closeListener, RecordType.FUEL))
        view.record_type_service.setOnClickListener(onClickListener(closeListener, RecordType.SERVICE))

        return builder.create()
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        actionListener.onAction(Actions.Home.RecordTypeDialogClosed)
    }

    private fun onClickListener(closeListener: View.OnClickListener, recordType: RecordType): View.OnClickListener {
        return OnClickListenerAdapter(Actions.Home.RecordTypeChoice(recordType), actionListener)
                .let {
                    View.OnClickListener { v ->
                        it.onClick(v)
                        closeListener.onClick(v)
                    }
                }
    }

    private fun actionListener(activity: FragmentActivity): ActionListener {
        return if (activity is ActionListener) activity else object : ActionListener {
            override fun onAction(action: Action) {

            }
        }
    }
}