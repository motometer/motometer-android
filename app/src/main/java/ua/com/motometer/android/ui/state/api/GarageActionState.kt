package ua.com.motometer.android.ui.state.api

interface GarageActionState : State {

    fun changeState(action: Actions.Garage): State {
        return when (action) {
            is Actions.Garage.Add -> this.changeState(action)
            is Actions.Garage.Empty -> this.changeState(action)
            is Actions.Garage.FinishCreate -> this.changeState(action)
            is Actions.Garage.Cancel -> this.changeState(action)
            is Actions.Garage.VehicleDetails -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Garage.Add): State

    fun changeState(action: Actions.Garage.VehicleDetails): State

    fun changeState(action: Actions.Garage.Empty): State

    fun changeState(action: Actions.Garage.FinishCreate): State

    fun changeState(action: Actions.Garage.Cancel): State
}