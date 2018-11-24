package ua.com.motometer.android.ui.state.home;

import org.immutables.value.Value;

import java.math.BigDecimal;

@Value.Immutable
public interface FuelRecord extends ExpenseRecord {

    String petrolStationName();

    BigDecimal fuelPrice();

    BigDecimal fuelRefilled();
}
