package ua.com.motometer.android.core.facade

import ua.com.motometer.android.core.facade.model.Vehicle

interface GarageFacade {

    fun vehicles(): List<Vehicle>
}