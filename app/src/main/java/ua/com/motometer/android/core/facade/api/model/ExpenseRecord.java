package ua.com.motometer.android.core.facade.api.model;

import org.immutables.value.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value.Immutable
public interface ExpenseRecord {
    @Value.Parameter
    long id();

    @Value.Parameter
    BigDecimal amount();

    @Value.Parameter
    LocalDate date();

    @Value.Parameter
    String description();
}
