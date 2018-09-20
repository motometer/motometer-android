package ua.com.motometer.android.core.facade.api

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.firebase.FirebaseModule
import ua.com.motometer.android.core.firebase.FirebaseAdapter
import ua.com.motometer.android.core.facade.impl.DefaultUserFacade
import ua.com.motometer.android.core.facade.impl.StubGarageFacade

@Module(includes = [FirebaseModule::class])
class FacadeModule {

    @Provides
    fun provideAccountFacade(firebaseAdapter: FirebaseAdapter): UserFacade = DefaultUserFacade(firebaseAdapter)

    @Provides
    fun provideGarageFacade(): GarageFacade = StubGarageFacade()
}
