package ua.com.motometer.android.core.facade.api.model

import org.immutables.value.Value

import java.math.BigDecimal
import java.time.LocalDate

@Value.Immutable
interface ExpenseRecord {

    @Value.Parameter
    fun amount(): BigDecimal

    @Value.Parameter
    fun date(): LocalDate

    @Value.Parameter
    fun description(): String
}
