package ua.com.motometer.android.ui.activity

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.UserRepository
import ua.com.motometer.android.core.facade.api.VehicleRepository
import ua.com.motometer.android.ui.model.ViewModelFactory

@Module(includes = [FacadeModule::class])
class ActivityModule {

    @Provides
    fun provideViewModelFactory(userRepository: UserRepository,
                                vehicleRepository: VehicleRepository): ViewModelFactory =
            ViewModelFactory(userRepository, vehicleRepository)
}