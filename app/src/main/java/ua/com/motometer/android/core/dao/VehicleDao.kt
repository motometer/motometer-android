package ua.com.motometer.android.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface VehicleDao {

    @Query("SELECT * FROM Vehicle")
    fun findAll(): List<Vehicle>

    @Query("SELECT * FROM Vehicle WHERE id = :id")
    fun findById(id: Long): Flowable<Vehicle>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vehicle: Vehicle)

    @Query("SELECT count(id) FROM Vehicle")
    fun count(): Long
}
