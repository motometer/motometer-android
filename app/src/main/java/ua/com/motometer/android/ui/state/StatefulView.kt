package ua.com.motometer.android.ui.state

interface StatefulView {
    fun renderViewState(oldState: State, newState: State)
}