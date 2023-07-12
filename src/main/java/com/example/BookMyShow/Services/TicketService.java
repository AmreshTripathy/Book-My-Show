package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.TicketRequestDto;
import com.example.BookMyShow.Dtos.ResponseDtos.TicketResponseDto;
import com.example.BookMyShow.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amresh Tripathy
 */

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto) {
        return null;
    }
}
