package edu.ysu.klam.passwordmanager;
import java.util.UUID;

public class Login {
    private String email;
    private String user;
    private String password;
    private String website;
    private UUID id;

    public Login() { // constructor
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String toString() {
        String string = website +
                        "\nEmail: " + email +
                        "\nLogin: " + user +
                        "\nPassword: " + password + "\n";
        return string;
    }
}
