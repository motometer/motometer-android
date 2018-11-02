package ua.com.motometer.android.ui.state

import android.util.Log
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.State

object NewVehicle : State {
    override fun changeState(action: Action): State {
        return when (logAction(action)) {
            is Actions.Common.Back -> Garage
            is Actions.Garage.FinishCreate -> NewVehicleCreated
            is Actions.Garage.Add -> this
            is Actions.Garage.Cancel -> Garage
            else -> defaultNoOp(action)
        }
    }

    private fun defaultNoOp(action: Action): NewVehicle {
        Log.d(javaClass.simpleName, "Doing nothing for action $action")
        return this
    }
}