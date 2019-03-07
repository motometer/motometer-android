package ua.com.motometer.android.core.facade.api

import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.dao.RecordDao
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.dao.VehicleDao
import ua.com.motometer.android.core.facade.impl.DefaultUserRepository
import ua.com.motometer.android.core.facade.impl.RoomExpenseRepository
import ua.com.motometer.android.core.facade.impl.RoomGarageRepository
import ua.com.motometer.android.core.firebase.FirebaseAdapter
import ua.com.motometer.android.core.firebase.FirebaseModule

@Module(includes = [FirebaseModule::class, RoomModule::class])
class FacadeModule {

    @Provides
    fun provideUserRepository(firebaseAdapter: FirebaseAdapter): UserRepository = DefaultUserRepository(firebaseAdapter)

    @Provides
    fun provideGarageRepository(vehicleDao: VehicleDao): VehicleRepository = RoomGarageRepository(vehicleDao)

    @Provides
    fun provideExpenseRepository(recordDao: RecordDao): ExpenseRepository = RoomExpenseRepository(recordDao)
}
