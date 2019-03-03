package ua.com.motometer.android.core.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record")
class Record(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String,

        @ColumnInfo(name = "odometer")
        val odometer: Int,

        @ColumnInfo(name = "amount")
        val amount: Double,

        @ColumnInfo(name = "comment")
        val comment: String,

        @ColumnInfo(name = "date")
        val date: String,

        @ColumnInfo(name = "fuel_record_id")
        val fuelRecordId: String? = null
)