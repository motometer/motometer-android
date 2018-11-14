package ua.com.motometer.android.ui.state

import ua.com.motometer.android.ui.state.home.FuelRecord
import java.math.BigDecimal
import java.time.LocalDate

object FuelRecordFixture : FuelRecord {
    override fun date(): LocalDate {
        TODO("not implemented")
    }

    override fun petrolStationName(): String {
        TODO("not implemented")
    }

    override fun fuelPrice(): BigDecimal {
        TODO("not implemented")
    }

    override fun fuelRefilled(): BigDecimal {
        TODO("not implemented")
    }

    override fun fuelTotalAmount(): BigDecimal {
        TODO("not implemented")
    }

    override fun odometer(): Int {
        TODO("not implemented")
    }

    override fun comment(): String {
        TODO("not implemented")
    }
}