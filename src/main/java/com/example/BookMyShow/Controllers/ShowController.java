package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowDto;
import com.example.BookMyShow.Dtos.RequestDtos.ShowSeatDto;
import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amresh Tripathy
 */

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/add")
    public String addShow(@RequestBody AddShowDto addShowDto) {
        try {
            return showService.addShow(addShowDto);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping("/associate-seats")
    public String associateSeats(@RequestBody ShowSeatDto showSeatDto) {
        try {
            return showService.associateShowSeats(showSeatDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
}
