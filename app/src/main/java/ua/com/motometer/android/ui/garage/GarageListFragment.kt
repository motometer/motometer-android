package ua.com.motometer.android.ui.garage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.DaggerFacadesComponent
import ua.com.motometer.android.core.facade.GarageFacade
import ua.com.motometer.android.core.facade.model.Vehicle
import ua.com.motometer.android.ui.common.ReadWriteTask
import javax.inject.Inject

class GarageListFragment : Fragment() {

    @Inject
    lateinit var garageFacade: GarageFacade

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.garage_list, container, false)

        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            ReadWriteTask(garageFacade::vehicles) { vehicles ->
                view.adapter = GarageListRecyclerViewAdapter(vehicles, listener)
            }.execute()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFacadesComponent.create().inject(this)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Vehicle?)
    }
}
