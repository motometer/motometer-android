package ua.com.motometer.android.facade

import io.reactivex.Observable
import ua.com.motometer.android.facade.model.UserDetails

interface AccountFacade {

    fun signIn()

    fun currentUser(): Observable<UserDetails>
}