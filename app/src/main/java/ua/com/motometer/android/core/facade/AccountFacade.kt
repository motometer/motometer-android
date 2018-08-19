package ua.com.motometer.android.core.facade

import io.reactivex.Observable
import ua.com.motometer.android.core.facade.model.UserDetails

interface AccountFacade {

    fun signIn()

    fun currentUser(): Observable<UserDetails>
}