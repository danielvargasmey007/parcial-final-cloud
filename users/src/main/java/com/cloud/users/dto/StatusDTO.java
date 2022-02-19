package com.cloud.users.dto;

import java.io.Serializable;

/**
 * The Class StatusDTO.
 */
public class StatusDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5022341805021141326L;

    /** The response. */
    private Object response;
    
    /** The message. */
    private String message;

    /**
     * Gets the response.
     *
     * @return the response
     */
    public Object getResponse() {
        return response;
    }

    /**
     * Sets the response.
     *
     * @param response the new response
     */
    public void setResponse(Object response) {
        this.response = response;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Instantiates a new status DTO.
     */
    public StatusDTO() {
    }

    /**
     * Instantiates a new status DTO.
     *
     * @param response the response
     * @param message  the message
     */
    public StatusDTO(Object response, String message) {
        this.response = response;
        this.message = message;
    }
}