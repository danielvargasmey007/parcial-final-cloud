package com.cloud.bookings.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class BookingDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3508614065674052752L;

    private String id;

    /** The name. */
    @NotBlank(message = "User id its requeried")
    private String userId;

    /** The name. */
    @NotBlank(message = "Show Time Id id its requeried")
    private String showTimeId;

    @NotEmpty(message = "Date its requeried")
    private List<MovieDTO> movies;

    public BookingDTO(String id, @NotBlank(message = "User id its requeried") String userId,
            @NotBlank(message = "Show Time Id id its requeried") String showTimeId,
            @NotEmpty(message = "Date its requeried") List<com.cloud.bookings.dto.MovieDTO> movies) {
        this.id = id;
        this.userId = userId;
        this.showTimeId = showTimeId;
        this.movies = movies;
    }

    public BookingDTO() {
        super();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(String showTimeId) {
        this.showTimeId = showTimeId;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

}
