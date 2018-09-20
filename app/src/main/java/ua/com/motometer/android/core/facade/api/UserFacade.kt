package ua.com.motometer.android.core.facade.api

import ua.com.motometer.android.core.facade.api.model.User

interface UserFacade {

    fun signIn()

    fun currentUser(): User

    fun isAuthenticated(): Boolean
}