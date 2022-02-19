package com.cloud.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloud.movies.domain.Movie;

/**
 * The Interface MovieRepository.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(
            value = "SELECT COUNT(*) FROM show_time_movie stm WHERE stm.movie_id =:id", 
            nativeQuery = true)
    Integer hasShowtime(Long id);
}
