package ua.com.motometer.android.core.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [
    Vehicle::class,
    Record::class
], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao

    abstract fun recordDao(): RecordDao

    companion object {

        @Volatile
        private var INSTANCE: ApplicationDatabase? = null

        const val DB_NAME = "motometer.db"

        fun getInstance(context: Context): ApplicationDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        ApplicationDatabase::class.java, DB_NAME)
                        .build()
    }
}
