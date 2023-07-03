package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.TheaterEntryDto;
import com.example.BookMyShow.Dtos.RequestDtos.TheaterSeatsEntryDto;
import com.example.BookMyShow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amresh Tripathy
 */

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto) {
        try {
            return theaterService.addTheater(theaterEntryDto);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody TheaterSeatsEntryDto theaterSeatsEntryDto) {
        try {
            return theaterService.addTheaterSeats(theaterSeatsEntryDto);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
