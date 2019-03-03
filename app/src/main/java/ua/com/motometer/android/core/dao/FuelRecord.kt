package ua.com.motometer.android.core.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FuelRecord")
class FuelRecord(

        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String,

        @ColumnInfo(name = "petrolStationName")
        val petrolStationName: String,

        @ColumnInfo(name = "fuelPrice")
        val fuelPrice: Double,

        @ColumnInfo(name = "fuelAmount")
        val fuelAmount: Double
)