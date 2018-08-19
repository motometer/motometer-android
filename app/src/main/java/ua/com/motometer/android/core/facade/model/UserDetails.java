package ua.com.motometer.android.core.facade.model;

import org.immutables.value.Value;

@Value.Immutable
public interface UserDetails {

    @Value.Parameter
    String displayName();

    @Value.Parameter
    String email();
}
