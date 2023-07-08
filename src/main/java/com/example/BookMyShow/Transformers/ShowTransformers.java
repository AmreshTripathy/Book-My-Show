package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowDto;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.TheaterRepository;

/**
 * @author Amresh Tripathy
 */
public class ShowTransformers {

    public static Show convertDtoToEntity(AddShowDto addShowDto) {

        return Show.builder()
                .time(addShowDto.getShowStartTime())
                .date(addShowDto.getShowDate())
                .build();
    }
}
