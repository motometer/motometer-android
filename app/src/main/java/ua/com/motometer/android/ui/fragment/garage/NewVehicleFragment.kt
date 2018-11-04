package ua.com.motometer.android.ui.fragment.garage

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import java.time.LocalDate

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
            fragment.findViewById<Button>(R.id.new_vehicle_finish)
                    .setOnClickListener(OnClickListenerAdapter(Actions.Garage.FinishCreate, actionListener!!))

            fragment.findViewById<EditText>(R.id.new_vehicle_bought_date_edit)
                    .setOnFocusChangeListener { view, hasFocus ->
                        view as EditText
                        if (hasFocus) {
                            val newFragment = ua.com.motometer.android.ui.fragment.common.DatePickerDialog()
                            newFragment.listener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                                val localDate = LocalDate.of(year, month, dayOfMonth)
                                view.setText(localDate.toString())
                                Log.d(javaClass.simpleName, "Chosen date $localDate")
                            }

                            newFragment.show(activity?.supportFragmentManager, "datePicker")
                        }
                    }

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
