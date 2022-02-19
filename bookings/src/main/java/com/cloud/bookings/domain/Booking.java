package com.cloud.bookings.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name. */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "show_time_id", nullable = false)
    private Long showTimeId;

    @ManyToMany
    @JoinTable(name = "show_time_movie", joinColumns = {
            @JoinColumn(name = "show_time_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "movie_id") })
    private List<Movie> movies;

    public Booking(Long id, Long userId, Long showTimeId, List<Movie> movies) {
        this.id = id;
        this.userId = userId;
        this.showTimeId = showTimeId;
        this.movies = movies;
    }

    public Booking(Long id) {
        super();
        this.id = id;
    }
    
    

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(Long showTimeId) {
        this.showTimeId = showTimeId;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
