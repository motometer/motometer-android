package ua.com.motometer.android.core.facade.api

import ua.com.motometer.android.core.facade.api.model.Vehicle

interface GarageFacade {

    fun vehicles(): List<Vehicle>
}