package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amresh Tripathy
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
