package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.TheaterEntryDto;
import com.example.BookMyShow.Dtos.RequestDtos.TheaterSeatsEntryDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Exception.NoTheaterFoundException;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.TheaterSeat;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amresh Tripathy
 */

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) {
        Theater theater = TheaterTransformers.convertDtoToEntity(theaterEntryDto);
        theaterRepository.save(theater);
        return "A new theater has been added successfully";
    }

    public String addTheaterSeats(TheaterSeatsEntryDto theaterSeatsEntryDto) throws NoTheaterFoundException {
        int columns = theaterSeatsEntryDto.getNoOfSeatsInOneRow();

        int noOfClassicSeats = theaterSeatsEntryDto.getNoOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsEntryDto.getNoOfPremiumSeats();

        Theater theater = theaterRepository.findByLocation(theaterSeatsEntryDto.getLocation());
        if (theater == null)
            throw new NoTheaterFoundException("Theater Not Found!");

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        int counter = 1;
        char ch = 'A';

        // ClassicSeats
        for (int count = 1; count <= noOfClassicSeats; count++) {
            if (columns == (ch - 'A') || (ch - 'A') == 26) {
                counter++;
                ch = 'A';
            }

            String seatNo = counter + (String.valueOf(ch++));

            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo).seatType(SeatType.CLASSIC).theater(theater).build();

            // Bidirectional mapping
            theaterSeatList.add(theaterSeat);
        }

        // PremiumSeats
        for (int count = 1; count <= noOfPremiumSeats; count++) {
            if (columns == (ch - 'A') || (ch - 'A') == 26) {
                counter++;
                ch = 'A';
            }

            String seatNo = counter + (String.valueOf(ch++));

            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo).seatType(SeatType.PREMIUM).theater(theater).build();

            // Bidirectional mapping
            theaterSeatList.add(theaterSeat);

        }

        // No need to set theaterSeatList to theater because the address is same for both instance
        // So automatically it is adding to the referenced memory (refer --> Swallow Concept in OOPs)
        theaterRepository.save(theater);

        return "Theater Seats have been successfully added";
    }
}
