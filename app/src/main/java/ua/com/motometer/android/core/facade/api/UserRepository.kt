package ua.com.motometer.android.core.facade.api

import io.reactivex.Flowable
import ua.com.motometer.android.core.facade.api.model.User

interface UserRepository {

    fun currentUser(): Flowable<User>

    fun isAuthenticated(): Boolean
}