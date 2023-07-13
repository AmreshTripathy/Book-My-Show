package com.example.BookMyShow.Dtos.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author Amresh Tripathy
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {

    private LocalTime showTime;

    private Date showDate;

    private String movieName;

    private String theaterName;

    private String bookedSeats;

    private boolean foodAdded;

    private String location;

    private int totalPrice;

}
