package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.RequestDtos.AddMovieDto;
import com.example.BookMyShow.Models.Movie;

/**
 * @author Amresh Tripathy
 */
public class MovieTransformers {

    public static Movie convertDtoToEntity(AddMovieDto addMovieDto) {
        return Movie.builder()
                .movieName(addMovieDto.getMovieName())
                .duration(addMovieDto.getDuration())
                .genre(addMovieDto.getGenre())
                .language(addMovieDto.getLanguage())
                .rating(addMovieDto.getRating())
                .releaseDate(addMovieDto.getReleaseDate())
                .build();
    }
}
