package ua.com.motometer.android.ui.fragment.home

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.VehicleRepository
import ua.com.motometer.android.ui.fragment.common.injector
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import javax.inject.Inject


class VehicleChoiceDialog : DialogFragment() {

    @Inject
    lateinit var vehicleRepository: VehicleRepository

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        injector().inject(this)

        val builder = AlertDialog.Builder(activity)

        val actionListener: ActionListener = activity as ActionListener

        //TODO get rid of block
        val vehicles = vehicleRepository.vehicles().blockingFirst()!!

        val strings = vehicles.map { "${it.registrationNumber()} ${it.manufacturer()} ${it.model()}" }
                .toTypedArray()

        return builder.setTitle(R.string.vehicle_choice)
                .setItems(strings) { _, index ->
                    actionListener.onAction(Actions.Home.ChoseVehicle(vehicles[index].id()))
                }.create()
    }
}