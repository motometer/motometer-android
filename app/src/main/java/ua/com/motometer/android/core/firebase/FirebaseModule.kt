package ua.com.motometer.android.core.firebase

import dagger.Module
import dagger.Provides

@Module
open class FirebaseModule {

    @Provides
    open fun provideFirebaseAdapter(): FirebaseAdapter = FirebaseAdapterImpl()
}