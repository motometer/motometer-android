package ua.com.motometer.android.ui.fragment.garage

import android.view.View
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions

class VehicleOnClickListener(private val actionListener: ActionListener) : View.OnClickListener {
    override fun onClick(view: View?) {
        val vehicle = view!!.tag as Vehicle
        actionListener.onAction(Actions.Garage.VehicleDetails(vehicle.id()))
    }
}