package com.cloud.users.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

/**
 * The Class UserDTO.
 */
public class UserDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6879529078216414703L;

    /** The id. */
    private String id;

    /** The name. */
    @NotBlank(message = "Name its requeried")
    private String name;

    /** The last name. */
    @NotBlank(message = "Last Name its requeried")
    private String lastName;

    /**
     * Instantiates a new user DTO.
     */
    public UserDTO() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
