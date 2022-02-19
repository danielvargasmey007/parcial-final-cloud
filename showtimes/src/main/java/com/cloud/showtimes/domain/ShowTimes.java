package com.cloud.showtimes.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "SHOW_TIMES")
public class ShowTimes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name. */
    @Column(name = "date", nullable = false)
    private Date date;
    
    @ManyToMany
    @JoinTable(
        name = "show_time_movie", 
        joinColumns = { @JoinColumn(name = "show_time_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "movie_id") }
    )
    private List<Movie> movies;

    
    public ShowTimes() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    
}
