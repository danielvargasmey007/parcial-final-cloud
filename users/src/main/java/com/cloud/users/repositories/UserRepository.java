package com.cloud.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloud.users.domain.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            value = "SELECT COUNT(*) FROM booking b WHERE b.user_id =:id", 
            nativeQuery = true)
    Integer hasBooking(Long id);
}
