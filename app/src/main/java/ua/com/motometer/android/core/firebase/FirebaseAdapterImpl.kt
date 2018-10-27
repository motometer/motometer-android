package ua.com.motometer.android.core.firebase

import com.google.firebase.auth.FirebaseAuth
import ua.com.motometer.android.core.facade.api.model.User

internal class FirebaseAdapterImpl : FirebaseAdapter{
    override fun getCurrentUser(): User = FirebaseUserAdapter(FirebaseAuth.getInstance().currentUser!!)

    override fun isAuthenticated(): Boolean = FirebaseAuth.getInstance().currentUser != null
}