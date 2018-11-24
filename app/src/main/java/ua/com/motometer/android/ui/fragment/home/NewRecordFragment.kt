package ua.com.motometer.android.ui.fragment.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.control_buttons.view.*
import ua.com.motometer.android.ui.adapter.OnClickListenerAdapter
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.home.OnSubmitRecordListener
import ua.com.motometer.android.ui.state.home.RecordType


class NewRecordFragment : Fragment() {
    private var listener: ActionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val recordTypeOrdinal = arguments?.get(RECORD_TYPE) as Int
        val recordType1 = RecordType.values()[recordTypeOrdinal]
        val view = inflater.inflate(recordType1.viewId, container, false)

        view.button_submit.setOnClickListener(OnSubmitRecordListener(view, activity as ActionListener, recordType1.expenseRecordFactory))
        view.button_cancel.setOnClickListener(OnClickListenerAdapter(Actions.Common.Back, activity as ActionListener))
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        const val RECORD_TYPE = "RECORD_TYPE"
    }
}
