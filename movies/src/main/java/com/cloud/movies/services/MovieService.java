package com.cloud.movies.services;

import java.util.List;

import com.cloud.movies.domain.Movie;

public interface MovieService {

    List<Movie> getMovies();

    Movie createMovie(Movie movie);

    Movie getMovieById(Long id);

    Long deleteMovie(Long id) throws Exception;
}
