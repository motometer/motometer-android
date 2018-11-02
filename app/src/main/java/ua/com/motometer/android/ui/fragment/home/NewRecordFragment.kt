package ua.com.motometer.android.ui.fragment.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.state.api.ActionListener


class NewRecordFragment : Fragment() {
    private var listener: ActionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_record, container, false)
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
}
