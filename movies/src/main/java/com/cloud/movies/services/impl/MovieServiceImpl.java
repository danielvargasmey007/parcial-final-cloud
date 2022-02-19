package com.cloud.movies.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.movies.domain.Movie;
import com.cloud.movies.repositories.MovieRepository;
import com.cloud.movies.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie createMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return this.movieRepository.findById(id).orElse(null);
    }

    @Override
    public Long deleteMovie(Long id) throws Exception {
        if(this.movieRepository.hasShowtime(id) > 0) {
            throw new Exception("Movie has show time");
        }
        this.movieRepository.delete(new Movie(id));
        return id;
    }

}
