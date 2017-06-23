package tvautrin.labs.microservices.oauth2.provider.web.dto;

/**
 * Created by Thomas VAUTRIN on 26/04/2017.
 */
public class UserInfo {

    private String username;
    private String password;
    private boolean enabled;
    private String role;

    /**
     * Gets the value of the enabled property.
     *
     * @return possible object is
     * {@link boolean }
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set the value of the enabled property.
     *
     * @param enabled the new value
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
