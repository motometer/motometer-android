package ua.com.motometer.android.ui.state.api

interface StatefulView {
    fun renderViewState(oldState: State, newState: State)
}