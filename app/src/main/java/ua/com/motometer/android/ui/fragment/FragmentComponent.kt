package ua.com.motometer.android.ui.fragment

import dagger.Component
import ua.com.motometer.android.ui.activity.ActivityModule
import ua.com.motometer.android.ui.fragment.garage.ListFragment
import ua.com.motometer.android.ui.fragment.garage.VehicleDetailsFragment
import ua.com.motometer.android.ui.fragment.home.RecordListFragment
import ua.com.motometer.android.ui.fragment.home.VehicleChoiceDialog
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface FragmentComponent {

    fun inject(app: ListFragment)

    fun inject(vehicleDetailsFragment: VehicleDetailsFragment)

    fun inject(recordListFragment: RecordListFragment)

    fun inject(vehicleChoiceDialog: VehicleChoiceDialog)
}