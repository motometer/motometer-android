package ua.com.motometer.android.ui.state.api

import ua.com.motometer.android.ui.state.home.RecordType

sealed class Actions : Action {

    sealed class Common : Actions() {
        object Back : Common()
        object OpenMenu : Common()
        object CloseMenu : Common()
        object DrawerClosed : Common()
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
        object AddNewRecord : Home()
        object SubmitRecord : Home()
        object RecordTypeDialogClosed : Home()
        data class RecordTypeChoice(val recordType: RecordType) : Home()
        class TrackRecordDetails(val trackRecordId: Long) : Home()
    }
}