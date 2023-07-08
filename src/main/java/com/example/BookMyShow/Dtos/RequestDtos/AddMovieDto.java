package com.example.BookMyShow.Dtos.RequestDtos;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;

/**
 * @author Amresh Tripathy
 */

@Data
public class AddMovieDto {

    private String movieName;

    private int duration;

    private double rating;

    private Date releaseDate;

    private Genre genre;

    private Language language;
}
