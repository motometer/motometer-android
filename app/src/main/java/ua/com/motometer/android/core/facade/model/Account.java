package ua.com.motometer.android.core.facade.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Account {

    UserDetails userDetails();
}
