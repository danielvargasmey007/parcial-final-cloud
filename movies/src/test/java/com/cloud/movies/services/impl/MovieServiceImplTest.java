package com.cloud.movies.services.impl;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloud.movies.domain.Movie;
import com.cloud.movies.repositories.MovieRepository;
import com.cloud.movies.services.MovieService;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class MovieServiceImplTest {
    
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;
    
    @Before
    public void init() {
        movieService = new MovieServiceImpl(movieRepository);
    }
    
    @Test
    public void testCreateMovie() {
        Mockito.when(movieRepository.save(Mockito.any(Movie.class))).thenReturn(new Movie());

        Assert.assertNotNull(this.movieService.createMovie(new Movie()));
    }

}
