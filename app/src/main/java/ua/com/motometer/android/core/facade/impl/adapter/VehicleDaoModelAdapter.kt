package ua.com.motometer.android.core.facade.impl.adapter

import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.core.dao.Vehicle as VehicleDaoModel
import java.math.BigDecimal
import java.time.LocalDate

class VehicleDaoModelAdapter(private val vehicle: VehicleDaoModel) : Vehicle {

    override fun id(): Long = vehicle.id

    override fun type(): String = vehicle.type

    override fun manufacturer(): String = vehicle.manufacturer

    override fun model(): String = vehicle.model

    override fun builtYear(): Int = vehicle.builtYear

    override fun vin(): String = vehicle.vin

    override fun boughtDate(): LocalDate = LocalDate.parse(vehicle.boughtDate)

    override fun price(): BigDecimal = BigDecimal(vehicle.price)

    override fun currency(): String = vehicle.currency
}