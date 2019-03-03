package ua.com.motometer.android.ui.fragment.garage


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import ua.com.motometer.android.ui.model.VehicleViewModel
import ua.com.motometer.android.ui.model.ViewModelFactory
import javax.inject.Inject

class VehicleDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: VehicleViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        DaggerFragmentComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(activity!!.application))
                .build()
                .inject(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_vehicle_details, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(VehicleViewModel::class.java)
        viewModel.vehicle(arguments!!.getLong("vehicleId"))
        viewModel.vehicle.observe(this, Observer { openVehicle(view, it) })
        return view
    }

    private fun openVehicle(view: View, it: Vehicle?) {
        if (it == null) {
            return
        }

        Log.d(javaClass.simpleName, "Found vehicle with id ${it.id()}")
        view.findViewById<TextView>(R.id.details_model).text = it.model()
        view.findViewById<TextView>(R.id.details_manufacturer).text = it.manufacturer()
        view.findViewById<TextView>(R.id.details_built_year).text = it.builtYear().toString()
        view.findViewById<TextView>(R.id.details_bought_date).text = it.boughtDate().toString()
        view.findViewById<TextView>(R.id.details_currency).text = it.currency()
        view.findViewById<TextView>(R.id.details_price).text = it.price().toString()
        view.findViewById<TextView>(R.id.details_type).text = it.type()
        view.findViewById<TextView>(R.id.details_reg_number).text = it.registrationNumber()
    }
}
