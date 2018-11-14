package ua.com.motometer.android.ui.state.home;

import org.immutables.value.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

import ua.com.motometer.annotations.NotNullByDefault;

@Value.Immutable
@NotNullByDefault
public interface FuelRecord {
    LocalDate date();

    String petrolStationName();

    BigDecimal fuelPrice();

    BigDecimal fuelRefilled();

    BigDecimal fuelTotalAmount();

    int odometer();

    String comment();
}
