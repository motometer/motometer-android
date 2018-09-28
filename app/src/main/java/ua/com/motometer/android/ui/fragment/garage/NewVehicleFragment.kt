package ua.com.motometer.android.ui.fragment.garage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.state.ActionListener
import ua.com.motometer.android.ui.state.Actions

class NewVehicleFragment : Fragment() {

    private var actionListener: ActionListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ActionListener) {
            actionListener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_new_vehicle, container, false)
        registerListeners(fragment)
        return fragment
    }

    private fun registerListeners(fragment: View) {
        if (actionListener != null) {
            fragment.findViewById<Button>(R.id.new_vehicle_cancel)
                    .setOnClickListener(OnClickListenerAdapter(Actions.Garage.Cancel, actionListener!!))
        }
    }
}
