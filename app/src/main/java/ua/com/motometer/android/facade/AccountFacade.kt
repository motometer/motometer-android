package ua.com.motometer.android.facade

import ua.com.motometer.android.facade.model.Account

interface AccountFacade {

    fun signIn()

    fun currentUser(): Account
}