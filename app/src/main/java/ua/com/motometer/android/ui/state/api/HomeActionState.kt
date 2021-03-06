package ua.com.motometer.android.ui.state.api

interface HomeActionState : State {

    fun changeState(action: Actions.Home): State {
        return when (action) {
            is Actions.Home.TrackRecordDetails -> this.changeState(action)
            is Actions.Home.AddNewRecord -> this.changeState(action)
            is Actions.Home.RecordTypeChoice -> this.changeState(action)
            is Actions.Home.RecordTypeDialogClosed -> this.changeState(action)
            is Actions.Home.SubmitFuel -> this.changeState(action)
            is Actions.Home.SubmitService -> this.changeState(action)
            is Actions.Home.ChoseVehicle -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Home.AddNewRecord): State

    fun changeState(action: Actions.Home.TrackRecordDetails): State

    fun changeState(action: Actions.Home.RecordTypeChoice): State

    fun changeState(action: Actions.Home.RecordTypeDialogClosed): State

    fun changeState(action: Actions.Home.SubmitFuel): State = this

    fun changeState(action: Actions.Home.SubmitService): State = this

    fun changeState(action: Actions.Home.ChoseVehicle): State
}