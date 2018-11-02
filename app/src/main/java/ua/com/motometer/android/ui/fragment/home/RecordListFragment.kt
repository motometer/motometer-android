package ua.com.motometer.android.ui.fragment.home

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
import ua.com.motometer.android.core.facade.api.ExpenseFacade
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import ua.com.motometer.android.ui.state.api.ActionListener
import javax.inject.Inject

class RecordListFragment : Fragment() {

    private var listener: ActionListener? = null
    @Inject
    lateinit var expenseFacade: ExpenseFacade

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recordlist_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = RecordListRecyclerViewAdapter(expenseFacade.expenses(), listener)
            }
        }
        return view
    }

    override fun onAttach(actionListener: Context) {
        super.onAttach(actionListener)

        DaggerFragmentComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(activity!!.application))
                .build()
                .inject(this)

        if (actionListener is ActionListener) {
            listener = actionListener
        } else {
            throw RuntimeException(actionListener.toString() + " must implement ActionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
