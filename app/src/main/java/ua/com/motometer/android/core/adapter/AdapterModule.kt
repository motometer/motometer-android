package ua.com.motometer.android.core.adapter

import dagger.Module
import dagger.Provides

@Module
open class AdapterModule {

    @Provides
    open fun provideFirebaseAdapter(): FirebaseAdapter = FirebaseAdapterImpl()
}