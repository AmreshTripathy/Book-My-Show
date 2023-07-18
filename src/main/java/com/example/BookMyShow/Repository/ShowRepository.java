package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;


/**
 * @author Amresh Tripathy
 */
public interface ShowRepository extends JpaRepository<Show, Integer> {

    @Query(value = "select movie_id from shows where date = :checkDate group by movie_id order by count(id) desc limit 1", nativeQuery = true)
    public Integer getMostShowedMovie(@Param("checkDate") Date checkDate);
}
