package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Amresh Tripathy
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where age >= :enteredAge", nativeQuery = true)
    List<User> findUsersWithAgeGrater(Integer enteredAge);
    // This is a custom function
    // I need to custom query on top of this
}
