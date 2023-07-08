package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.AddMovieDto;
import com.example.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amresh Tripathy
 */

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public String addMovie(@RequestBody AddMovieDto addMovieDto) {
        return movieService.addMovie(addMovieDto);
    }
}
