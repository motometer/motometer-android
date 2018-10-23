package ua.com.motometer.android.core.facade.impl

import ua.com.motometer.android.core.dao.VehicleDao
import ua.com.motometer.android.core.facade.api.GarageFacade
import ua.com.motometer.android.core.facade.api.model.ImmutableVehicle
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.core.facade.api.model.toDaoModel
import ua.com.motometer.android.core.facade.impl.adapter.VehicleDaoModelAdapter

class RoomGarageFacade(private var vehicleDao: VehicleDao) : GarageFacade {

    override fun vehicles(): List<Vehicle> {
        return vehicleDao.findAll()
                .map(::VehicleDaoModelAdapter)
    }

    override fun registerVehicle(registration: Vehicle) {
        ImmutableVehicle.copyOf(registration)
                .withId(vehicleDao.count())
                .toDaoModel()
                .let(vehicleDao::insert)
    }

    override fun vehicle(vehicleId: Long): Vehicle =
            vehicleDao.findById(vehicleId).let(::VehicleDaoModelAdapter)
}