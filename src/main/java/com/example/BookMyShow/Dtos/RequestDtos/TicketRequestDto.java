package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

import java.util.List;

/**
 * @author Amresh Tripathy
 */

@Data
public class TicketRequestDto {
    private int showId;

    private int userId;

    private List<String> requestedSeats;

    private boolean foodAdded;
}
