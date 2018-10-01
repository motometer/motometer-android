package ua.com.motometer.android.ui.activity

import dagger.Component
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.ui.fragment.garage.ListFragment
import ua.com.motometer.android.ui.fragment.garage.VehicleDetailsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [FacadeModule::class])
interface FacadeComponent {
    fun inject(app: AbstractMenuActivity)

    fun inject(garageActivity: GarageActivity)

    fun inject(app: ListFragment)

    fun inject(launcherActivity: LauncherActivity)

    fun inject(vehicleDetailsFragment: VehicleDetailsFragment)
}