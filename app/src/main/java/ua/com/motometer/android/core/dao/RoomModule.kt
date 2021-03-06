package ua.com.motometer.android.core.dao

import android.app.Application
import dagger.Module
import dagger.Provides
import ua.com.motometer.android.core.db.ApplicationDatabase
import javax.inject.Singleton

@Module
class RoomModule(application: Application) {
    var applicationDatabase: ApplicationDatabase? = null

    init {
        applicationDatabase = ApplicationDatabase.getInstance(application)
    }

    @Provides
    @Singleton
    fun provideVehicleDao(): VehicleDao = applicationDatabase!!.vehicleDao()

    @Provides
    @Singleton
    fun provideRecordDao(): RecordDao = applicationDatabase!!.recordDao()
}