package ua.com.motometer.android.ui.state

class CloseApp : State {
    override fun changeState(action: Action): State =
            throw UnsupportedOperationException("Application should be closed")
}