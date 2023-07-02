package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

/**
 * @author Amresh Tripathy
 */

@Data
public class AddUserDto {
    private String name;

    private Integer age;

    private String mobNo;

    private String emailId;
}
