package org.apicoding.labs.ms.web.domain;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
public class User {

    private Long id;

    private String firstname;

    private String lastname;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of the id property.
     *
     * @param id the new value
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the value of the firstname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the value of the firstname property.
     *
     * @param firstname the new value
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the value of the lastname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the value of the lastname property.
     *
     * @param lastname the new value
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
