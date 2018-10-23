package ua.com.motometer.android.core.dao

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "vehicle")
data class Vehicle(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Long,

        @ColumnInfo(name = "type")
        val type: String,

        @ColumnInfo(name = "manufacturer")
        val manufacturer: String,

        @ColumnInfo(name = "model")
        val model: String,

        @ColumnInfo(name = "builtYear")
        val builtYear: Int,

        @ColumnInfo(name = "vin")
        val vin: String,

        @ColumnInfo(name = "boughtDate")
        val boughtDate: String,

        @ColumnInfo(name = "price")
        val price: String,

        @ColumnInfo(name = "currency")
        val currency: String
)