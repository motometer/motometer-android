package ua.com.motometer.android.ui.state

interface MenuHandler {

    fun handleHome(state: Home)

    fun handleGarage(state: Garage)

    fun handleSignOut(state: SignOut)
}