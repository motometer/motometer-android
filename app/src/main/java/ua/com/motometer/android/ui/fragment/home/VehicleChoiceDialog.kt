package ua.com.motometer.android.ui.fragment.home

import android.app.AlertDialog
import android.app.Dialog
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.DialogFragment
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.VehicleRepository
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import javax.inject.Inject


class VehicleChoiceDialog : DialogFragment() {

    @Inject
    lateinit var vehicleRepository: VehicleRepository

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        DaggerFragmentComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(activity!!.application))
                .build()
                .inject(this)

        val builder = AlertDialog.Builder(activity)

        val actionListener: ActionListener = activity as ActionListener

        val vehicles = ReadTask()
                .execute(vehicleRepository)
                .get() //TODO don't use blocking get

        val strings = vehicles.map { "${it.registrationNumber()} ${it.manufacturer()} ${it.model()}" }
                .toTypedArray()

        return builder.setTitle(R.string.vehicle_choice)
                .setItems(strings) { _, index ->
                    actionListener.onAction(Actions.Home.ChoseVehicle(vehicles[index].id()))
                }.create()
    }
}

class ReadTask : AsyncTask<VehicleRepository, Unit, List<Vehicle>>() {
    override fun doInBackground(vararg params: VehicleRepository?): List<Vehicle> {
        return params.first()?.vehicles() ?: listOf()
    }
}