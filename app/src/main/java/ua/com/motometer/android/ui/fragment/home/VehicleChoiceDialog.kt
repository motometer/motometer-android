package ua.com.motometer.android.ui.fragment.home

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions


class VehicleChoiceDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val actionListener: ActionListener = activity as ActionListener

        return builder.setTitle(R.string.vehicle_choice)
                .setItems(arrayOf("Vw Jetta", "Audi Q7")) { dialog, which ->
                    actionListener.onAction(Actions.Home.ChoseRecord)
                }.create()
    }
}