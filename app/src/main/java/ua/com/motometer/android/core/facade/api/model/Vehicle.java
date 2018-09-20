package ua.com.motometer.android.core.facade.api.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Vehicle {

    @Value.Parameter
    String displayName();

    @Value.Parameter
    String displayImageUrl();

    @Value.Parameter
    int builtYear();
}
