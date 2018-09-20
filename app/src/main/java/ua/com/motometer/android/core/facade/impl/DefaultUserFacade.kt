package ua.com.motometer.android.core.facade.impl

import android.util.Log
import ua.com.motometer.android.core.firebase.FirebaseAdapter
import ua.com.motometer.android.core.facade.api.UserFacade
import ua.com.motometer.android.core.facade.api.model.User
import javax.inject.Inject

class DefaultUserFacade @Inject constructor(private val firebaseAdapter: FirebaseAdapter) : UserFacade {
    override fun signIn() {
        Log.d("", "User has signed in")
    }

    override fun currentUser(): User = firebaseAdapter.getCurrentUser()

    override fun isAuthenticated(): Boolean = firebaseAdapter.isAuthenticated()
}