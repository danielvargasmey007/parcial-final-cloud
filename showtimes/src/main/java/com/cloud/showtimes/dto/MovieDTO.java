package com.cloud.showtimes.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class MovieDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8294783786973451538L;

    /** The id. */
    private String id;

    /** The name. */
    @NotBlank(message = "Title its requeried")
    private String title;

    /** The name. */
    @NotBlank(message = "Director its requeried")
    private String director;

    @Min(1)
    @Max(5)
    private Integer rating;

    public MovieDTO(String id, @NotBlank(message = "Title its requeried") String title,
            @NotBlank(message = "Director its requeried") String director,
            @Min(1) @Max(5) Integer rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    public MovieDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
