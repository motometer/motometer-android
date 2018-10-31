package ua.com.motometer.android.ui.state

sealed class Actions : Action {

    sealed class Common : Actions() {
        object Back : Common()
        object OpenMenu : Common()
        object CloseMenu : Common()
    }

    sealed class Menu : Actions() {
        object Home : Menu()
        object Garage : Menu()
        object SignOut : Menu()
    }

    sealed class Garage : Actions() {
        object Empty : Garage()
        object Add : Garage()
        object FinishCreate : Garage()
        object Cancel : Garage()
        class VehicleDetails(val vehicleId: Long) : Garage()
    }

    sealed class Home : Actions() {
        class TrackRecordDetails(val trackRecordId: Long) : Home()
    }
}