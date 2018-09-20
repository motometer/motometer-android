package ua.com.motometer.android.ui.activity

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.com.motometer.android.R

/**
 * A placeholder fragment containing a simple view.
 */
class GarageActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_garage, container, false)
    }
}
