package ua.com.motometer.android.core.facade

import ua.com.motometer.android.core.facade.model.UserDetails

interface AccountFacade {

    fun signIn()

    fun currentUser(): UserDetails

    fun isAuthenticated(): Boolean
}