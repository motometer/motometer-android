package ua.com.motometer.android.core.facade.impl

import android.util.Log
import ua.com.motometer.android.core.adapter.FirebaseAdapter
import ua.com.motometer.android.core.facade.AccountFacade
import ua.com.motometer.android.core.facade.model.ImmutableUserDetails
import ua.com.motometer.android.core.facade.model.UserDetails
import javax.inject.Inject

class DefaultAccountFacade @Inject constructor(private val firebaseAdapter: FirebaseAdapter) : AccountFacade {
    override fun signIn() {
        Log.d("", "User has signed in")
    }

    override fun currentUser(): UserDetails {
        val currentUser = firebaseAdapter.getCurrentUser()
        return ImmutableUserDetails.of(currentUser.displayName!!, currentUser.email!!)
    }

    override fun isAuthenticated(): Boolean = firebaseAdapter.isAuthenticated()
}