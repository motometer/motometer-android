package ua.com.motometer.android.core.facade.api.model;

import org.immutables.value.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value.Immutable
public interface Vehicle {

    long id();

    String type();

    String manufacturer();

    String model();

    int builtYear();

    String vin();

    LocalDate boughtDate();

    BigDecimal price();

    String currency();
}
