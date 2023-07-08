package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

/**
 * @author Amresh Tripathy
 */

@Data
public class ShowSeatDto {

    private int showId;

    private int priceForClassicSeats;

    private int priceForPremiumSeats;
    
}
