package ua.com.motometer.android.facade.impl

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import ua.com.motometer.android.facade.AccountFacade
import ua.com.motometer.android.facade.model.ImmutableUserDetails
import ua.com.motometer.android.facade.model.UserDetails
import javax.inject.Inject

class DefaultAccountFacade @Inject constructor() : AccountFacade {
    override fun signIn() {
        Log.d("", "User has signed in")
    }

    override fun currentUser(): UserDetails {
        val currentUser = FirebaseAuth.getInstance().currentUser!!
        return ImmutableUserDetails.of(currentUser.displayName!!, currentUser.email!!)
    }
}