package ua.com.motometer.android.core.facade.api.model;

import org.immutables.value.Value;

@Value.Immutable
public interface User {

    @Value.Parameter
    String displayName();

    @Value.Parameter
    String email();

    @Value.Parameter
    String avatarUrl();
}
