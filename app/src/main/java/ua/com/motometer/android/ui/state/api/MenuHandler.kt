package ua.com.motometer.android.ui.state.api

import ua.com.motometer.android.ui.state.Garage
import ua.com.motometer.android.ui.state.Home
import ua.com.motometer.android.ui.state.SignOut

interface MenuHandler {

    fun handleHome(state: Home)

    fun handleGarage(state: Garage)

    fun handleSignOut(state: SignOut)
}