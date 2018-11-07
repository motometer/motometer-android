package ua.com.motometer.android.ui.fragment.garage


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.GarageFacade
import ua.com.motometer.android.ui.common.ReadWriteTask
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import javax.inject.Inject

class VehicleDetailsFragment : Fragment() {

    @Inject
    lateinit var garageFacade: GarageFacade

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

        Log.d("T", "baadgba")

        ReadWriteTask(
                {
                    val id = arguments!!.getLong("vehicleId")
                    garageFacade.vehicle(id)
                } ,
                {
                    view.findViewById<TextView>(R.id.details_model).text = it.model()
                    view.findViewById<TextView>(R.id.details_manufacturer).text = it.manufacturer()
                    view.findViewById<TextView>(R.id.details_built_year).text = it.builtYear().toString()
                    view.findViewById<TextView>(R.id.details_bought_date).text = it.boughtDate().toString()
                    view.findViewById<TextView>(R.id.details_currency).text = it.currency()
                    view.findViewById<TextView>(R.id.details_price).text = it.price().toString()
                    view.findViewById<TextView>(R.id.details_type).text = it.type()
                    view.findViewById<TextView>(R.id.details_reg_number).text = it.registrationNumber()
                }
        ).execute()

        return view
    }
}
