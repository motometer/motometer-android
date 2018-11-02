package ua.com.motometer.android.ui.state

data class VehicleDetails(val vehicleId: Long) : State {
    override fun changeState(action: Action): State {
        return when (action) {
            is Actions.Common.Back -> Garage
            else -> Garage
        }
    }
}