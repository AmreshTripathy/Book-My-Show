package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

/**
 * @author Amresh Tripathy
 */

@Data
public class TheaterSeatsEntryDto {

    private int noOfSeatsInOneRow;

    private int noOfClassicSeats;

    private int noOfPremiumSeats;

    private String location;

}
