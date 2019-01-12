package ua.com.motometer.android.ui.state.api

import ua.com.motometer.android.core.facade.api.model.FuelRecord
import ua.com.motometer.android.core.facade.api.model.ServiceRecord
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
        data class SubmitFuel(val fuelRecord: FuelRecord) : Home()
        data class SubmitService(val serviceRecord: ServiceRecord) : Home()
        object RecordTypeDialogClosed : Home()
        data class ChoseVehicle(val vehicleId: Long) : Home()

        data class RecordTypeChoice(val recordType: RecordType) : Home()
        class TrackRecordDetails(val trackRecordId: Long) : Home()
    }
}