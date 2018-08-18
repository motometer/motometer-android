package ua.com.motometer.android.facade

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.facade.impl.DefaultAccountFacade

@Module
class FacadesModule {

    @Provides
    fun provideAccountFacade(): AccountFacade = DefaultAccountFacade()
}
