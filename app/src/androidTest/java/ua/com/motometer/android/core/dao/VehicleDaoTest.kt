package ua.com.motometer.android.core.dao

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class VehicleDaoTest : AbstractDaoTest() {

    @Test
    fun nextId() {
        val vehicleDao = applicationDatabase.vehicleDao()

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
    }
}