package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.TicketRequestDto;
import com.example.BookMyShow.Dtos.ResponseDtos.TicketResponseDto;
import com.example.BookMyShow.Exception.UserNotFound;
import com.example.BookMyShow.Exception.ShowNotFound;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.Ticket;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TicketRepository;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Transformers.TicketTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Amresh Tripathy
 */

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto) throws Exception {

        int userId = ticketRequestDto.getUserId();

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty())
            throw new UserNotFound("User not found!");

        int showId = ticketRequestDto.getShowId();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty())
            throw new ShowNotFound("Show not found");

        User user = optionalUser.get();
        Show show = optionalShow.get();

        // validation for requested seats

        boolean isValid = validateAndCalculatePrice(show, ticketRequestDto.getRequestedSeats());

        if (!isValid)
            throw new Exception("Requested seats entered are not available");

        Ticket ticket = new Ticket();

        ticket.setUser(user);

        ticket.setShow(show);

        int totalPrice = calculateTotalPrice(show, ticketRequestDto.getRequestedSeats(), ticketRequestDto.isFoodAdded());

        ticket.setTotalTicketsPrice(totalPrice);

        ticket.setFoodAdded(true);

        ticket.setBookedSeats(String.valueOf(ticketRequestDto.getRequestedSeats()).replace("[", "").replace("]", ""));

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);

        show.getTicketList().add(ticket);

        userRepository.save(user);
        showRepository.save(show);

        return TicketTransformers.convertEntityToDto(ticket, show);
    }

    private boolean validateAndCalculatePrice(Show show, List<String> requestedSeats) {

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for (ShowSeat showSeat : showSeatList) {
            String seatNo = showSeat.getSeatNo();
            if (requestedSeats.contains(seatNo) && !showSeat.isAvailable())
                return false;
        }


        return true;
    }

    private int calculateTotalPrice(Show show, List<String> requestedSeats, boolean isFoodAdded) {

        int totalPrice = 0;

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for (ShowSeat showSeat : showSeatList) {
            if (requestedSeats.contains(showSeat.getSeatNo())) {
                totalPrice += (isFoodAdded) ? showSeat.getPrice() + 100 : showSeat.getPrice();
                showSeat.setAvailable(false);
                showSeat.setFoodAttached(true);
            }
        }

        return totalPrice;
    }
}
