package ua.com.motometer.android.core.facade.api.model

import java.math.BigDecimal
import java.time.LocalDate

interface Record {
    fun date(): LocalDate

    fun odometer(): Int

    fun comment(): String

    fun amount(): BigDecimal
}
