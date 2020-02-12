package ru.itfb.trial.security;

import org.springframework.security.core.userdetails.UserDetails;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.model.Role;

import java.util.Collection;
import java.util.Collections;


public class ClientDetails implements UserDetails {

    private Client client;

    public ClientDetails(Client client) {
        this.client = client;
    }

    @Override
    public Collection<Role> getAuthorities() {
        return client.getRoles();
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
