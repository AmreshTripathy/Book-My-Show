package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.AddMovieDto;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Transformers.MovieTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amresh Tripathy
 */

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieDto addMovieDto) {
        Movie movie = MovieTransformers.convertDtoToEntity(addMovieDto);

        movieRepository.save(movie);

        return "Movie added successfully";
    }
}
