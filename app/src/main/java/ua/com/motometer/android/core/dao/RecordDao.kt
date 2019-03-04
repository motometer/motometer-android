package ua.com.motometer.android.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface RecordDao {

    @Insert
    fun insert(record: Record)

    @Query("SELECT * FROM Record")
    fun findAll(): Single<List<Record>>
}