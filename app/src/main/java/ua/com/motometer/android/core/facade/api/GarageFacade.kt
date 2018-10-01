package ua.com.motometer.android.core.facade.api

import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.core.facade.api.model.VehicleDetails

interface GarageFacade {

    fun vehicles(): List<Vehicle>

    fun registerVehicle(registration: VehicleDetails)

    fun vehicle(vehicleId: Long): VehicleDetails
}