package com.cloud.showtimes.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ShowTimeDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 485851023104935405L;

    /** The id. */
    private String id;

    @NotBlank(message = "Date its requeried")
    private String date;

    @NotEmpty(message = "Date its requeried")
    private List<MovieDTO> movies;

    public ShowTimeDTO(String id, @NotBlank(message = "Date its requeried") String date,
            @NotEmpty(message = "Date its requeried") List<MovieDTO> movies) {
        this.id = id;
        this.date = date;
        this.movies = movies;
    }

    public ShowTimeDTO() {
        super();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

}
