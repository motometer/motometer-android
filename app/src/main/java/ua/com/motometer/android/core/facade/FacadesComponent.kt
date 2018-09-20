package ua.com.motometer.android.core.facade

import dagger.Component
import ua.com.motometer.android.ui.activity.AbstractMenuActivity
import ua.com.motometer.android.ui.activity.LauncherActivity
import ua.com.motometer.android.ui.activity.SignInActivity
import ua.com.motometer.android.ui.garage.GarageListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [FacadesModule::class])
interface FacadesComponent {
    fun inject(app: AbstractMenuActivity)

    fun inject(app: GarageListFragment)

    fun inject(app: SignInActivity)

    fun inject(launcherActivity: LauncherActivity)
}