package ua.com.motometer.android.core.facade.api.model

import org.immutables.value.Value

import java.math.BigDecimal

@Value.Immutable
interface FuelRecord : Record {

    fun petrolStationName(): String

    fun fuelPrice(): BigDecimal

    fun fuelRefilled(): BigDecimal
}
