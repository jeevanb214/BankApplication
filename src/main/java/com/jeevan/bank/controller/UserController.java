package com.jeevan.bank.controller;

import com.jeevan.bank.dto.UserDto;
import com.jeevan.bank.dto.response.ApiResponse;
import com.jeevan.bank.exception.BankException;
import com.jeevan.bank.serviceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/createUser")
    public ApiResponse createUser(@RequestBody @Valid UserDto userDto) throws Exception {
        ApiResponse<UserDto> apiResponse = new ApiResponse<>();
        try {
            validateUserDto(userDto);
            userDto = userService.saveUser(userDto);
            apiResponse.setResultData(userDto);
            apiResponse.setMessage("created a user successfully");
            apiResponse.setSuccess(true);
        } catch (BankException bankException) {
            log.error("Exception while creating a user");
            throw new BankException();
        } catch (Exception exception) {
            log.error("Exception while creating a user");
            throw new Exception();
        }
        return apiResponse;
    }

    private void validateUserDto(UserDto userDto) {
        if (userDto.getEmail() == null)
            throw new BankException("Email not found");
        if (userDto.getContact() == null)
            throw new BankException("Contact not found");
        if (userDto.getFirstName() == null)
            throw new BankException("First name not found");
        if (userDto.getUserType() == null)
            throw new BankException("User type not found");
        if (userDto.getPassword() == null)
            throw new BankException("Password not found");

    }

    @PutMapping("/updateUser")
    public ApiResponse updateUser(@RequestBody @Valid UserDto userDto) throws Exception {
        ApiResponse<UserDto> apiResponse = new ApiResponse<>();
        try {
            userDto = userService.updateUser(userDto);
            apiResponse.setResultData(userDto);
            apiResponse.setMessage("updated a user successfully");
            apiResponse.setSuccess(true);
        } catch (BankException bankException) {
            log.error("Exception while updating a user");
            throw new BankException();
        } catch (Exception exception) {
            log.error("Exception while updating a user");
            throw new Exception();
        }
        return apiResponse;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ApiResponse deleteUser(@PathVariable("id") @NotBlank Long id) throws Exception {
        ApiResponse apiResponse = new ApiResponse<>();
        try {
            userService.deleteUser(id);
            apiResponse.setResultData(id);
            apiResponse.setMessage("deleted a user successfully");
            apiResponse.setSuccess(true);
        } catch (BankException bankException) {
            log.error("Exception while deleting a user");
            throw new BankException();
        } catch (Exception exception) {
            log.error("Exception while deleting a user");
            throw new Exception();
        }
        return apiResponse;
    }

    @GetMapping("/getUser/{id}")
    public ApiResponse getUser(@PathVariable(name = "id") @NotBlank Long id) throws Exception {
        ApiResponse<UserDto> apiResponse = new ApiResponse<>();
        try {
            UserDto userDto = userService.getUser(id);
            apiResponse.setResultData(userDto);
            apiResponse.setMessage("fetched a user successfully");
            apiResponse.setSuccess(true);
        } catch (BankException bankException) {
            log.error("Exception while getting a user");
            throw new BankException();
        } catch (Exception exception) {
            log.error("Exception while getting a user");
            throw new Exception();
        }
        return apiResponse;
    }

    @GetMapping("/getUser/{id}")
    public ApiResponse getAllUsers() throws Exception {
        ApiResponse<List<UserDto>> apiResponse = new ApiResponse<>();
        try {
            List<UserDto> userDtoList = userService.getAllUsers();
            apiResponse.setResultData(userDtoList);
            apiResponse.setMessage("fetched all user successfully");
            apiResponse.setSuccess(true);
        } catch (BankException bankException) {
            log.error("Exception while fetching a user");
            throw new BankException();
        } catch (Exception exception) {
            log.error("Exception while fetching a user");
            throw new Exception();
        }
        return apiResponse;
    }

}
