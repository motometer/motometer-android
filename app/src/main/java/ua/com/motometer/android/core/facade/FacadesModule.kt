package ua.com.motometer.android.core.facade

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.facade.impl.DefaultAccountFacade
import ua.com.motometer.android.core.facade.impl.StubGarageFacade

@Module
class FacadesModule {

    @Provides
    fun provideAccountFacade(): AccountFacade = DefaultAccountFacade()

    @Provides
    fun provideGarageFacade(): GarageFacade = StubGarageFacade()
}
