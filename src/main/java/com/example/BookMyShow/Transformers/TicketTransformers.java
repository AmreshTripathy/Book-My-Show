package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.ResponseDtos.TicketResponseDto;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.Ticket;

/**
 * @author Amresh Tripathy
 */
public class TicketTransformers {

    public static TicketResponseDto convertEntityToDto(Ticket ticket, Show show) {
        return TicketResponseDto.builder()
                .showTime(show.getTime())
                .showDate(show.getDate())
                .movieName(show.getMovie().getMovieName())
                .theaterName(show.getTheater().getName())
                .bookedSeats(ticket.getBookedSeats())
                .foodAdded(ticket.isFoodAdded())
                .location(show.getTheater().getLocation())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();
    }
}
