package ua.com.motometer.android.core.facade.impl

import io.reactivex.Flowable
import ua.com.motometer.android.core.dao.VehicleDao
import ua.com.motometer.android.core.facade.api.VehicleRepository
import ua.com.motometer.android.core.facade.api.model.ImmutableVehicle
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.core.facade.api.model.toDaoModel
import ua.com.motometer.android.core.facade.impl.adapter.VehicleDaoModelAdapter

class RoomGarageRepository(private var vehicleDao: VehicleDao) : VehicleRepository {

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

    override fun vehicle(vehicleId: Long): Flowable<Vehicle> =
            vehicleDao.findById(vehicleId).map(::VehicleDaoModelAdapter)
}