package ua.com.motometer.android.core.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import ua.com.motometer.android.core.dao.Record
import ua.com.motometer.android.core.dao.RecordDao
import ua.com.motometer.android.core.dao.Vehicle
import ua.com.motometer.android.core.dao.VehicleDao

@Database(entities = [
    Vehicle::class,
    Record::class
], version = 2)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao

    abstract fun recordDao(): RecordDao

    companion object {

        @Volatile
        private var INSTANCE: ApplicationDatabase? = null

        const val DB_NAME = "motometer.db"

        fun getInstance(context: Context): ApplicationDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        ApplicationDatabase::class.java, DB_NAME)
                        .addMigrations(V2)
                        .build()
    }
}
