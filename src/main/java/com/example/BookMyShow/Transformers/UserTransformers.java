package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.RequestDtos.AddUserDto;
import com.example.BookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.BookMyShow.Models.User;

/**
 * @author Amresh Tripathy
 */
public class UserTransformers {

    public static User convertDtoToEntity(AddUserDto userDto) {
        return User.builder().name(userDto.getName()).age(userDto.getAge()).mobNo(userDto.getMobNo()).emailId(userDto.getEmailId()).build();
    }

    public static UserResponseDto convertEntityToDto(User user) {
        return UserResponseDto.builder().name(user.getName()).age(user.getAge()).mobNo(user.getMobNo()).emailId((user.getEmailId())).build();
    }
}
