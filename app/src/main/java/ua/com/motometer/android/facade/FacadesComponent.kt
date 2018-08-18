package ua.com.motometer.android.facade

import dagger.Component
import ua.com.motometer.android.activity.HomeActivity
import ua.com.motometer.android.activity.SignInActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [FacadesModule::class])
interface FacadesComponent {
    fun inject(app: HomeActivity)

    fun inject(app: SignInActivity)
}