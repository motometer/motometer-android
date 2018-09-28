package ua.com.motometer.android.ui.state

sealed class Actions : Action {

    sealed class Common : Actions() {
        object Back : Common()
        object OpenMenu : Common()
        object CloseMenu : Common()
    }

    sealed class Menu : Actions() {
        object Home : Menu()
        object Garage : Menu()
        object SignOut : Menu()
    }

    sealed class Garage : Actions() {
        object Add : Garage()
        object Cancel : Garage()
    }
}