package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.RequestDtos.TheaterEntryDto;
import com.example.BookMyShow.Models.Theater;

/**
 * @author Amresh Tripathy
 */
public class TheaterTransformers {

    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto) {
        return Theater.builder().name(theaterEntryDto.getName()).location(theaterEntryDto.getLocation()).build();
    }
}
