package ua.com.motometer.android.ui.fragment.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.fragment.common.injector
import ua.com.motometer.android.ui.model.ExpenseViewModel
import ua.com.motometer.android.ui.model.ViewModelFactory
import javax.inject.Inject

class RecordListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var vm: ExpenseViewModel
    private val viewAdapter = RecordListRecyclerViewAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recordlist_list, container, false)

        vm = ViewModelProviders.of(this, viewModelFactory)[ExpenseViewModel::class.java]

        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = viewAdapter
            vm.expenses()
            vm.expenses.observe(this, Observer(viewAdapter::submitList))
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector().inject(this)
    }
}
