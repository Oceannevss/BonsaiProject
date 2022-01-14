package fr.paris8.iutmontreuil.frameworkProject.authentication.domain;

import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.AuthorityId;

import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String username;
    private String password;
    private boolean enabled;
    private List<AuthorityId> authorities;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AuthorityId> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityId> authorities) {
        this.authorities = authorities;
    }
}
