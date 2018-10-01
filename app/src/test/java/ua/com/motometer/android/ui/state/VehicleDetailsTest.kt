package ua.com.motometer.android.ui.state

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class VehicleDetailsTest {

    private val vehicleDetails: VehicleDetails = VehicleDetails(10)

    @Test
    fun pressBack() {
        val result = vehicleDetails.changeState(Actions.Common.Back)

        assertThat(result).isInstanceOf(Garage::class.java)
    }
}