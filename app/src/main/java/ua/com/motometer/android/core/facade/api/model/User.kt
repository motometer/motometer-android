package ua.com.motometer.android.core.facade.api.model

import org.immutables.value.Value

@Value.Immutable
interface User {

    @Value.Parameter
    fun displayName(): String

    @Value.Parameter
    fun email(): String

    @Value.Parameter
    fun avatarUrl(): String
}
