package ua.com.motometer.android.ui.fragment.garage

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.VehicleRepository
import ua.com.motometer.android.ui.common.ReadWriteTask
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import ua.com.motometer.android.ui.fragment.common.ListenerFragment
import ua.com.motometer.android.ui.state.api.Actions
import javax.inject.Inject

class ListFragment : ListenerFragment() {

    @Inject
    lateinit var vehicleRepository: VehicleRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.garage_list, container, false)

        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            ReadWriteTask(vehicleRepository::vehicles) { vehicles ->
                if (vehicles.isEmpty()) {
                    listener!!.onAction(Actions.Garage.Empty)
                } else {
                    view.adapter = ListRecyclerViewAdapter(vehicles, listener!!)
                }
            }.execute()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(activity!!.application))
                .build()
                .inject(this)
    }
}
