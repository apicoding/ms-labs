package org.apicoding.labs.ms.gateway.web.dto;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Thomas VAUTRIN on 16/02/2017.
 */
@JsonIgnoreProperties
public class UserDTO {

    private String login;

    private List<String> authorities = new ArrayList<>();

    /**
     * Gets the value of the login property.
     *
     * @return possible object is {@link String }
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set the value of the login property.
     *
     * @param login
     *            the new value
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the value of the authorities property.
     *
     * @return possible object is {@link List<String> }
     */
    public List<String> getAuthorities() {
        return authorities;
    }

    /**
     * Set the value of the authorities property.
     *
     * @param authorities
     *            the new value
     */
    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
