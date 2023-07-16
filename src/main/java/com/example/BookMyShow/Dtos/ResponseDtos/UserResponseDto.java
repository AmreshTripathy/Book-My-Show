package com.example.BookMyShow.Dtos.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amresh Tripathy
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String name;

    private int age;

    private String mobNo;

    private String emailId;

    private String statusCode;

    private String statusMessage;
}
