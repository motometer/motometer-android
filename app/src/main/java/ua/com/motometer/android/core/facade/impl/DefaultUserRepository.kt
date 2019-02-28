package ua.com.motometer.android.core.facade.impl

import io.reactivex.Flowable
import ua.com.motometer.android.core.facade.api.UserRepository
import ua.com.motometer.android.core.facade.api.model.User
import ua.com.motometer.android.core.firebase.FirebaseAdapter
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(private val firebaseAdapter: FirebaseAdapter) : UserRepository {

    override fun currentUser(): Flowable<User> = Flowable.fromCallable { firebaseAdapter.getCurrentUser() }

    override fun isAuthenticated(): Boolean = firebaseAdapter.isAuthenticated()
}