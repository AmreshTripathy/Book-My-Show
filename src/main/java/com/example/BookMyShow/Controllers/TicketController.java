package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.TicketRequestDto;
import com.example.BookMyShow.Dtos.ResponseDtos.TicketResponseDto;
import com.example.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amresh Tripathy
 */

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book-ticket")
    public TicketResponseDto bookTicket(@RequestBody TicketRequestDto ticketRequestDto) {
        try {
            return ticketService.bookTicket(ticketRequestDto);
        } catch (Exception ex) {
            return null;
        }
    }
}
