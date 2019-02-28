package ua.com.motometer.android.core.facade.api

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.dao.RecordDao
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.dao.VehicleDao
import ua.com.motometer.android.core.facade.impl.DefaultUserRepository
import ua.com.motometer.android.core.facade.impl.RoomExpenseFacade
import ua.com.motometer.android.core.facade.impl.RoomGarageFacade
import ua.com.motometer.android.core.firebase.FirebaseAdapter
import ua.com.motometer.android.core.firebase.FirebaseModule

@Module(includes = [FirebaseModule::class, RoomModule::class])
class FacadeModule {

    @Provides
    fun provideAccountFacade(firebaseAdapter: FirebaseAdapter): UserRepository = DefaultUserRepository(firebaseAdapter)

    @Provides
    fun provideGarageFacade(vehicleDao: VehicleDao): GarageFacade = RoomGarageFacade(vehicleDao)

    @Provides
    fun provideExpenseFacade(recordDao: RecordDao): ExpenseFacade = RoomExpenseFacade(recordDao)
}
