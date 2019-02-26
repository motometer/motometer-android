package ua.com.motometer.android.ui.fragment.common

import android.content.Context
import android.support.v4.app.Fragment
import ua.com.motometer.android.ui.state.api.ActionListener

open class ListenerFragment : Fragment() {

    protected var listener: ActionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ActionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}