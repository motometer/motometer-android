package ua.com.motometer.android.core.dao

import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VehicleDaoTest {

    private var applicationDatabase: ApplicationDatabase? = null

    @Before
    fun setUp() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        applicationDatabase = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java).build()
    }

    @After
    fun tearDown() = applicationDatabase!!.close()

    @Test
    fun nextId() {
        val vehicleDao = applicationDatabase!!.vehicleDao()

        val id = vehicleDao.count()

        assertThat(id).isEqualTo(0L)

        val newVehicle = Vehicle(
                id,
                "Car",
                "Audi",
                "Q7",
                2018,
                "vwv",
                "",
                "10.0",
                "USD")

        vehicleDao.insert(newVehicle)

        val nextId = vehicleDao.count()

        assertThat(nextId).isEqualTo(1L)

        val found = vehicleDao.findById(id)

        assertThat(found).isEqualTo(newVehicle)
    }
}