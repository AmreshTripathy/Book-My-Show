package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.AddUserDto;
import com.example.BookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.BookMyShow.Exception.UserNotFound;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Transformers.UserTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amresh Tripathy
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserDto userDto) {
        User user = UserTransformers.convertDtoToEntity(userDto);

        userRepository.save(user);

        return "User has been added Successfully";
    }

    public UserResponseDto getOldestUser() throws UserNotFound {
        // prevents you from exposing Primary key
        // prevents infinite recursion

        List<User> userList = userRepository.findAll();

        int maxAge = 0;
        User userAns = null;

        for (User user : userList) {
            if (maxAge < user.getAge()) {
                maxAge = user.getAge();
                userAns = user;
            }
        }

        if (userAns == null)
            throw new UserNotFound("No User Found!");

        // We need to transform a userEntity to the UserResponseDto

        return UserTransformers.convertEntityToDto(userAns);
    }

    public List<User> getAllUsersGreaterThan(Integer age) {
        return userRepository.findUsersWithAgeGrater(age);
    }
}
