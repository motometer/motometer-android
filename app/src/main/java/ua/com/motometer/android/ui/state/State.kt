package ua.com.motometer.android.ui.state

interface State {
    fun changeState(action: Action): State
}