package ua.com.motometer.android.ui.state.api

interface HomeActionState : State {

    fun changeState(action: Actions.Home): State {
        return when (action) {
            is Actions.Home.TrackRecordDetails -> this.changeState(action)
            is Actions.Home.AddNewRecord -> this.changeState(action)
        }
    }

    fun changeState(action: Actions.Home.AddNewRecord): State

    fun changeState(action: Actions.Home.TrackRecordDetails): State
}