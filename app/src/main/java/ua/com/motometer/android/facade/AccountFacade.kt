package ua.com.motometer.android.facade

import ua.com.motometer.android.facade.model.UserDetails

interface AccountFacade {

    fun signIn()

    fun currentUser(): UserDetails
}