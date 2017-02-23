package org.apicoding.labs.ms.gateway.web.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Thomas VAUTRIN on 16/02/2017.
 */
@JsonIgnoreProperties
public class UserDTO {

    private Date currentDate;

    private String firstname;

    private String lastname;

    /**
     * Gets the value of the firstname property.
     *
     * @return possible object is {@link String }
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the value of the firstname property.
     *
     * @param firstname
     *            the new value
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the value of the currentDate property.
     *
     * @return possible object is
     * {@link Date }
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     * Set the value of the currentDate property.
     *
     * @param currentDate the new value
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
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
