package ua.com.motometer.android.core.firebase

import ua.com.motometer.android.core.facade.api.model.User

interface FirebaseAdapter {
    fun getCurrentUser(): User

    fun isAuthenticated(): Boolean
}