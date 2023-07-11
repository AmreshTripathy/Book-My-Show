package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowDto;
import com.example.BookMyShow.Dtos.RequestDtos.ShowSeatDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Exception.MovieNotFound;
import com.example.BookMyShow.Exception.ShowNotFound;
import com.example.BookMyShow.Exception.TheaterNotFound;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Transformers.ShowTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Amresh Tripathy
 */

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addShow(AddShowDto addShowDto) throws TheaterNotFound, MovieNotFound {

        Show show = ShowTransformers.convertDtoToEntity(addShowDto);

        // Set the movie and theater

        Optional<Movie> movieOptional = movieRepository.findById(addShowDto.getMovieId());
        if (movieOptional.isEmpty())
            throw new MovieNotFound("Movie is not found!");

        Optional<Theater> theaterOptional = theaterRepository.findById(addShowDto.getTheaterId());
        if(theaterOptional.isEmpty())
            throw new TheaterNotFound("Theater is not found!");

        Movie movie = movieOptional.get();
        Theater theater = theaterOptional.get();

        show.setMovie(movie);
        show.setTheater(theater);

        show = showRepository.save(show);

        movie.getShowList().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been added and show id is " + show.getId() ;
    }

    public String associateShowSeats(ShowSeatDto showSeatDto) throws ShowNotFound {

        Optional<Show> optionalShow = showRepository.findById(showSeatDto.getShowId());

        if (optionalShow.isEmpty())
            throw new ShowNotFound("Show id is incorrect!");


        Show show = optionalShow.get();

        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        // Each seat needs to be added in the showSeatList
        List<ShowSeat> showSeatList = show.getShowSeatList();

        for (TheaterSeat theaterSeat : theaterSeatList) {
            ShowSeat showSeat = new ShowSeat();

            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC))
                showSeat.setPrice(showSeatDto.getPriceForClassicSeats());
            else
                showSeat.setPrice(showSeatDto.getPriceForPremiumSeats());

            // Foreign key mapping
            showSeat.setShow(show);
            showSeat.setAvailable(true);
            showSeat.setFoodAttached(false);

            showSeatList.add(showSeat);
        }

        showRepository.save(show);

        return "Show Seats has successfully added";
    }
}
