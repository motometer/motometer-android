package ua.com.motometer.android.facade.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Account {

    UserDetails userDetails();
}
