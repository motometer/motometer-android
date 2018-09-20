package ua.com.motometer.android.core.adapter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

internal class FirebaseAdapterImpl : FirebaseAdapter{
    override fun getCurrentUser(): FirebaseUser = FirebaseAuth.getInstance().currentUser!!

    override fun isAuthenticated(): Boolean = FirebaseAuth.getInstance().currentUser != null
}