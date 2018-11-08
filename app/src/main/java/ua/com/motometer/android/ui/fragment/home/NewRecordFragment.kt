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


class NewRecordFragment : Fragment() {
    private var listener: ActionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val viewId = arguments?.get(RECORD_TYPE_VIEW) as Int
        val view = inflater.inflate(viewId, container, false)

        view.button_submit.setOnClickListener(OnSubmitRecordListener(view, activity as ActionListener))
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
        const val RECORD_TYPE_VIEW = "RECORD_TYPE_VIEW"
    }
}
