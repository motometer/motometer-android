package ua.com.motometer.android.ui.fragment.garage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.fragment.common.ListenerFragment
import ua.com.motometer.android.ui.listener.DateOnFocusChangeListener
import ua.com.motometer.android.ui.state.api.Actions

class NewVehicleFragment : ListenerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_new_vehicle, container, false)
        registerListeners(fragment)
        return fragment
    }

    private fun registerListeners(fragment: View) {
        if (listener != null) {
            fragment.findViewById<Button>(R.id.button_cancel)
                    .setOnClickListener(OnClickListenerAdapter(Actions.Garage.Cancel, listener!!))
            fragment.findViewById<Button>(R.id.button_submit)
                    .setOnClickListener(OnClickListenerAdapter(Actions.Garage.FinishCreate, listener!!))

            fragment.findViewById<EditText>(R.id.new_vehicle_bought_date_edit)
                    .onFocusChangeListener = DateOnFocusChangeListener(activity!!)

            val spinner: Spinner = fragment.findViewById(R.id.new_vehicle_type_choice)
            ArrayAdapter.createFromResource(
                    fragment.context,
                    R.array.vehicle_type,
                    android.R.layout.simple_spinner_dropdown_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }
    }
}
