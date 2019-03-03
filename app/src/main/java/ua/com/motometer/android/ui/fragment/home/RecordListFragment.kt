package ua.com.motometer.android.ui.fragment.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.ExpenseFacade
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.ui.common.ReadWriteTask
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import javax.inject.Inject

class RecordListFragment : Fragment() {

    @Inject
    lateinit var expenseFacade: ExpenseFacade

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recordlist_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                ReadWriteTask(expenseFacade::expenses) {
                    adapter = RecordListRecyclerViewAdapter(it)
                }.execute()

            }
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
