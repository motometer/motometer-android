package ua.com.motometer.android.core.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface RecordDao {

    @Insert
    fun insert(record: Record)

    @Query("SELECT * FROM Record")
    fun findAll(): List<Record>
}