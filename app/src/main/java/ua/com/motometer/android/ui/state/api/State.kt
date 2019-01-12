package ua.com.motometer.android.ui.state.api

interface State {
    fun changeState(action: Action): State
}