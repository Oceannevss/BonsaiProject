package fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure;

public class ChangeUserAuthorityRequest {

    private String username;
    private String authority;

    public ChangeUserAuthorityRequest(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public ChangeUserAuthorityRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
