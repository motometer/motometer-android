package ua.com.motometer.android.ui.fragment

import dagger.Component
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.ui.fragment.garage.ListFragment
import ua.com.motometer.android.ui.fragment.garage.VehicleDetailsFragment
import ua.com.motometer.android.ui.fragment.home.RecordListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [FacadeModule::class])
interface FragmentComponent {

    fun inject(app: ListFragment)

    fun inject(vehicleDetailsFragment: VehicleDetailsFragment)

    fun inject(recordListFragment: RecordListFragment)
}