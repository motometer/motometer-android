package ua.com.motometer.android.core.facade

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.facade.impl.DefaultAccountFacade

@Module
class FacadesModule {

    @Provides
    fun provideAccountFacade(): AccountFacade = DefaultAccountFacade()
}
