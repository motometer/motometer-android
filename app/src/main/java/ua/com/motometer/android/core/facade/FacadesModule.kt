package ua.com.motometer.android.core.facade

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.adapter.AdapterModule
import ua.com.motometer.android.core.adapter.AdapterModule_ProvideFirebaseAdapterFactory
import ua.com.motometer.android.core.adapter.FirebaseAdapter
import ua.com.motometer.android.core.facade.impl.DefaultAccountFacade
import ua.com.motometer.android.core.facade.impl.StubGarageFacade

@Module(includes = [AdapterModule::class])
class FacadesModule {

    @Provides
    fun provideAccountFacade(firebaseAdapter: FirebaseAdapter): AccountFacade = DefaultAccountFacade(firebaseAdapter)

    @Provides
    fun provideGarageFacade(): GarageFacade = StubGarageFacade()
}
