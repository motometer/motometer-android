package ua.com.motometer.android.ui.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.control_buttons.view.*
import kotlinx.android.synthetic.main.fragment_new_record_fuel.view.*
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.listener.DateOnFocusChangeListener
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.home.OnSubmitRecordListener
import ua.com.motometer.android.ui.state.home.RecordType


class NewRecordFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val recordTypeOrdinal = arguments?.get(RECORD_TYPE) as Int
        val recordType1 = RecordType.values()[recordTypeOrdinal]
        val view = inflater.inflate(recordType1.viewId, container, false)

        view.button_submit.setOnClickListener(OnSubmitRecordListener(view, activity as ActionListener, recordType1.actionFactory))
        view.button_cancel.setOnClickListener(OnClickListenerAdapter(Actions.Common.Back, activity as ActionListener))
        view.date.onFocusChangeListener = DateOnFocusChangeListener(activity!!)
        return view
    }

    companion object {
        const val RECORD_TYPE = "RECORD_TYPE"
    }
}
