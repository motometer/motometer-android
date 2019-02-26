package ua.com.motometer.android.core.facade.api.model

import org.immutables.value.Value

import java.math.BigDecimal
import java.time.LocalDate

@Value.Immutable
interface Vehicle {

    fun id(): Long

    fun type(): String

    fun manufacturer(): String

    fun model(): String

    fun builtYear(): Int

    fun registrationNumber(): String

    fun boughtDate(): LocalDate

    fun price(): BigDecimal

    fun currency(): String
}
