package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Amresh Tripathy
 */

@Entity
@Table(name = "show_seats")
@Data
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int price; // Price stored for each seat

    private boolean isAvailable;

    private boolean isFoodAttached;

    @ManyToOne
    @JoinColumn
    private Show show;
}
