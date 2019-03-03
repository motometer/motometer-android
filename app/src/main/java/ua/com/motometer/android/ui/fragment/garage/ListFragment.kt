package ua.com.motometer.android.ui.fragment.garage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import ua.com.motometer.android.ui.fragment.common.ListenerFragment
import ua.com.motometer.android.ui.model.VehicleViewModel
import ua.com.motometer.android.ui.model.ViewModelFactory
import ua.com.motometer.android.ui.state.api.Actions
import javax.inject.Inject

class ListFragment : ListenerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: VehicleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.garage_list, container, false)

        val adapter = ListRecyclerViewAdapter(listener!!)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(VehicleViewModel::class.java)
        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = adapter
            viewModel.vehicles()
        }
        viewModel.vehicles.observe(this, Observer {
            if (it.isEmpty()){
                listener!!.onAction(Actions.Garage.Empty)
            }else{
                adapter.submitList(it)
            }
        })

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
