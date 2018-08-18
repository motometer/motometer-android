package ua.com.motometer.android.facade.model

import javax.inject.Inject

data class Account @Inject constructor(val userDetails: UserDetails)