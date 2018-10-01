package ua.com.motometer.android.ui.state

class NewVehicleCreated : State {
    override fun changeState(action: Action): State = Garage()
}