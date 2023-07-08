package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author Amresh Tripathy
 */

@Data
public class AddShowDto {
    private LocalTime showStartTime;

    private Date showDate;

    private int theaterId;

    private int movieId;
}
