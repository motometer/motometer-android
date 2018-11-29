package ua.com.motometer.android.ui.state

import ua.com.motometer.android.core.facade.api.model.FuelRecord
import ua.com.motometer.android.core.facade.api.model.ServiceRecord
import java.math.BigDecimal
import java.time.LocalDate

object FuelRecordFixture : FuelRecord, ServiceRecord {
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

    override fun amount(): BigDecimal {
        TODO("not implemented")
    }

    override fun odometer(): Int {
        TODO("not implemented")
    }

    override fun comment(): String {
        TODO("not implemented")
    }
}