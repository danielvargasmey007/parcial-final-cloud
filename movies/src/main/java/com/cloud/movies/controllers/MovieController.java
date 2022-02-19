package com.cloud.movies.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NameNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.movies.domain.Movie;
import com.cloud.movies.dto.MovieDTO;
import com.cloud.movies.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController extends BaseController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<MovieDTO> getMovies() throws Exception {
        List<Movie> response = this.movieService.getMovies();
        
        List<MovieDTO> responseDTO = response
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());

        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieDTO createUser(@Valid @RequestBody MovieDTO movieDTO) throws Exception {
        Movie movie = this.movieService.createMovie(modelMapper.map(movieDTO, Movie.class));
        return modelMapper.map(movie, MovieDTO.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public MovieDTO getMovieById(@Valid @PathVariable Long id) throws Exception {
        Movie movie = this.movieService.getMovieById(id);
        if(movie == null) throw new NameNotFoundException();
        return modelMapper.map(movie, MovieDTO.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Long deleteMovie(@Valid @PathVariable Long id) throws Exception {
        return this.movieService.deleteMovie(id);
    }

}
