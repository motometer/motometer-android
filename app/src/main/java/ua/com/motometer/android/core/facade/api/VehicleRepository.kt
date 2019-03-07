package ua.com.motometer.android.core.facade.api

import io.reactivex.Flowable
import ua.com.motometer.android.core.facade.api.model.Vehicle

interface VehicleRepository {

    fun vehicles(): Flowable<List<Vehicle>>

    fun registerVehicle(registration: Vehicle)

    fun vehicle(vehicleId: Long): Flowable<Vehicle>
}