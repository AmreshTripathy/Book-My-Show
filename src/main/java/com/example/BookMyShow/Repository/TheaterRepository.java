package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amresh Tripathy
 */
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    Theater findByLocation(String location);
}
