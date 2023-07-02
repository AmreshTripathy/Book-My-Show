package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.AddUserDto;
import com.example.BookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Amresh Tripathy
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody AddUserDto user) {
        try {
            return userService.addUser(user);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    // Get the oldest user object by age
    @GetMapping("/getOldestUser")
    public UserResponseDto getOldestUser() {
        try {
            UserResponseDto userResponseDto = userService.getOldestUser();

            userResponseDto.setStatusCode("200");
            userResponseDto.setStatusMessage("Success");

            return userResponseDto;
        } catch (Exception ex) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setStatusCode("500");
            userResponseDto.setStatusMessage("Failure");
            return userResponseDto;
        }
    }

    @GetMapping("/findUsersGreaterThanAAge")
    public List<User> getAllUsers(@RequestParam("age") Integer age) {
        return userService.getAllUsersGreaterThan(age);
    }

}
