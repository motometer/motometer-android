package ua.com.motometer.android.ui.fragment.garage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.GarageFacade
import ua.com.motometer.android.core.firebase.FirebaseModule
import ua.com.motometer.android.ui.activity.DaggerFacadeComponent
import ua.com.motometer.android.ui.common.ReadWriteTask
import ua.com.motometer.android.ui.state.ActionListener
import ua.com.motometer.android.ui.state.Actions
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var garageFacade: GarageFacade

    private var listener: ActionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.garage_list, container, false)

        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            ReadWriteTask(garageFacade::vehicles) { vehicles ->
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
        DaggerFacadeComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(activity!!.application))
                .firebaseModule(FirebaseModule())
                .build()
                .inject(this)
        listener = context as ActionListener
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
