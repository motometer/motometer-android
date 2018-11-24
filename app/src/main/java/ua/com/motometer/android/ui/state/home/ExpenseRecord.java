package ua.com.motometer.android.ui.state.home;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExpenseRecord {
    LocalDate date();

    int odometer();

    String comment();

    BigDecimal amount();
}
