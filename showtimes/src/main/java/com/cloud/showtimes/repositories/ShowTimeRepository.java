package com.cloud.showtimes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.showtimes.domain.ShowTimes;

/**
 * The Interface ShowTimeRepository.
 */
@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTimes, Long> {

}
