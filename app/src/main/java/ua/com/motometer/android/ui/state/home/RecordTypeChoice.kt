package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.CommonActionState
import ua.com.motometer.android.ui.state.api.HomeActionState
import ua.com.motometer.android.ui.state.api.MenuActionState
import ua.com.motometer.android.ui.state.api.State
import ua.com.motometer.android.ui.state.logAction

object RecordTypeChoice : MenuActionState, CommonActionState, HomeActionState {
    override fun changeState(action: Action): State {
        logAction(action)
        return when (action) {
            is Actions.Menu -> this.changeState(action)
            is Actions.Common -> this.changeState(action)
            is Actions.Home -> this.changeState(action)
            else -> this
        }
    }

    override fun changeState(action: Actions.Home.AddNewRecord): State = this

    override fun changeState(action: Actions.Home.TrackRecordDetails): State = this

    override fun changeState(action: Actions.Common.Back): State = VehicleChoice

    override fun changeState(action: Actions.Home.RecordTypeChoice): State = NewRecord(action.recordType)

    override fun changeState(action: Actions.Home.RecordTypeDialogClosed): State = Home

    override fun changeState(action: Actions.Home.SubmitFuel): State = this

    override fun changeState(action: Actions.Home.SubmitService): State = this

    override fun changeState(action: Actions.Home.ChoseVehicle): State = this
}