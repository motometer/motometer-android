package ua.com.motometer.android.core.facade.api.model;

import org.immutables.value.Value;

import java.math.BigDecimal;

@Value.Immutable
public interface FuelRecord extends Record {

    String petrolStationName();

    BigDecimal fuelPrice();

    BigDecimal fuelRefilled();
}
