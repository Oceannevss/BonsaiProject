package fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure;

public class UserCreationRequest {


    private String username;
    private String password;
    private String passwordConfirmation;

    public UserCreationRequest() {

    }


    public UserCreationRequest(String username, String password, String passwordConfirmation) {
        this.username = username;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
