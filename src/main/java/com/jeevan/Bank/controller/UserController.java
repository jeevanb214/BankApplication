package com.jeevan.Bank.controller;

import com.jeevan.Bank.dto.UserDto;
import com.jeevan.Bank.serviceImpl.UserServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/createUser")
    public UserDto createUser(@RequestBody UserDto userDto) {
        validateUserDto(userDto);
        userDto = userService.saveUser(userDto);
        return userDto;
    }

    @SneakyThrows
    private void validateUserDto(UserDto userDto) {
        if (userDto.getEmail() == null)
            throw new Exception("Email not found");
        if (userDto.getContact() == null)
            throw new Exception("Contact not found");
        if (userDto.getFirstName() == null)
            throw new Exception("First name not found");
        if (userDto.getUserType() == null)
            throw new Exception("User type not found");
        if (userDto.getPassword() == null)
            throw new Exception("Password not found");

    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        userDto = userService.updateUser(userDto);
        return userDto;
    }

    @DeleteMapping("/deleteUser/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id) {
        Boolean bool = userService.deleteUser(id);
        return bool;
    }

    @GetMapping("/getUser/{id}")
    public UserDto getUser(@PathVariable(name = "id") Long id) {
        UserDto userDto = userService.getUser(id);
        return userDto;
    }

}
