package ua.com.motometer.android.core.facade.impl.adapter

import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.core.facade.api.model.VehicleDetails

class VehicleAdapter(private val vehicleDetails: VehicleDetails) : Vehicle {

    override fun displayName(): String =
            vehicleDetails.manufacturer() + " " + vehicleDetails.model()

    override fun displayImageUrl(): String = ""

    override fun builtYear(): Int = vehicleDetails.builtYear()
}