package ua.com.motometer.android.core.facade.impl

import ua.com.motometer.android.core.facade.api.GarageFacade
import ua.com.motometer.android.core.facade.api.model.ImmutableVehicleDetails
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.core.facade.api.model.VehicleDetails
import ua.com.motometer.android.core.facade.impl.adapter.VehicleAdapter

class StubGarageFacade : GarageFacade {

    override fun vehicles(): List<Vehicle> = StubGarageFacade.list.map(::VehicleAdapter)

    override fun registerVehicle(registration: VehicleDetails) {
        StubGarageFacade.list.add(ImmutableVehicleDetails.copyOf(registration).withId(StubGarageFacade.list.size.toLong()))
    }

    object StubGarageFacade {
        val list = ArrayList<VehicleDetails>()
    }

    override fun vehicle(vehicleId: Long): VehicleDetails {
        return StubGarageFacade.list
                .find {
                    it.id() == vehicleId
                } ?: throw IllegalArgumentException("Invalid id $vehicleId")
    }
}