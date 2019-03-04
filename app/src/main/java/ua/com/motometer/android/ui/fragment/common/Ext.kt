package ua.com.motometer.android.ui.fragment.common

import androidx.fragment.app.Fragment
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.ui.fragment.DaggerFragmentComponent
import ua.com.motometer.android.ui.fragment.FragmentComponent

fun Fragment.injector(): FragmentComponent {
    return DaggerFragmentComponent.builder()
            .facadeModule(FacadeModule())
            .roomModule(RoomModule(activity!!.application))
            .build()
}