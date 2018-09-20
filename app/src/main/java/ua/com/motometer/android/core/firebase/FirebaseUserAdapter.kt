package ua.com.motometer.android.core.firebase

import com.google.firebase.auth.FirebaseUser
import ua.com.motometer.android.core.facade.api.model.User

internal class FirebaseUserAdapter(private val firebaseUser: FirebaseUser?) : User {
    override fun displayName(): String = firebaseUser!!.displayName!!

    override fun email(): String = firebaseUser!!.email!!
}