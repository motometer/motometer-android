package ua.com.motometer.android.ui.state

object NewVehicleCreated : State {
    override fun changeState(action: Action): State = Garage
}