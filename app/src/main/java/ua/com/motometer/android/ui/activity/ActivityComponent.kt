package ua.com.motometer.android.ui.activity

import dagger.Component
import ua.com.motometer.android.core.facade.api.FacadeModule
import javax.inject.Singleton

@Singleton
@Component(modules = [FacadeModule::class])
interface ActivityComponent {
    fun inject(app: AbstractMenuActivity)

    fun inject(garageActivity: GarageActivity)

    fun inject(launcherActivity: LauncherActivity)
}