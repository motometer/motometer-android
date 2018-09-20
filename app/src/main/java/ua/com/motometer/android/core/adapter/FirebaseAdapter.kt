package ua.com.motometer.android.core.adapter

import com.google.firebase.auth.FirebaseUser

interface FirebaseAdapter {
    fun getCurrentUser(): FirebaseUser

    fun isAuthenticated(): Boolean
}