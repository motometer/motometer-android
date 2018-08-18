package ua.com.motometer.android.facade.model

import javax.inject.Inject

data class UserDetails @Inject constructor(
        val displayName: String,
        val email: String
)