package com.example.BookMyShow.Models;

import jakarta.persistence.*;

/**
 * @author Amresh Tripathy
 */

@Entity
@Table(name = "Theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
