package ua.com.motometer.android.core.dao

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

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