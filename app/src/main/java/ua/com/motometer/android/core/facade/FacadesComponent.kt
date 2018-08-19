package ua.com.motometer.android.core.facade

import dagger.Component
import ua.com.motometer.android.ui.activity.HomeActivity
import ua.com.motometer.android.ui.activity.SignInActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [FacadesModule::class])
interface FacadesComponent {
    fun inject(app: HomeActivity)

    fun inject(app: SignInActivity)
}