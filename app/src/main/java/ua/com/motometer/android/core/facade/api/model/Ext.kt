package ua.com.motometer.android.core.facade.api.model

import ua.com.motometer.android.core.dao.Vehicle as VehicleDaoModel

fun Vehicle.toDaoModel(): VehicleDaoModel {
    return VehicleDaoModel(
            id(),
            type(),
            manufacturer(),
            model(),
            builtYear(),
            registrationNumber(),
            boughtDate().toString(),
            price().toString(),
            currency()
    )
}