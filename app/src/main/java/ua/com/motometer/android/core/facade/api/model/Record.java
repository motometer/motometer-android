package ua.com.motometer.android.core.facade.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Record {
    LocalDate date();

    int odometer();

    String comment();

    BigDecimal amount();
}
