package com.example.BookMyShow.Dtos.ResponseDtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author Amresh Tripathy
 */

@Data
public class TicketResponseDto {

    private LocalTime showTime;

    private Date showDate;

    private String movieName;

    private String theaterName;

    private String bookedSeats;

    private String location;

}
