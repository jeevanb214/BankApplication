package com.jeevan.bank.serviceImpl;

import com.jeevan.bank.constant.UserType;
import com.jeevan.bank.dto.BankDto;
import com.jeevan.bank.dto.UserDto;
import com.jeevan.bank.entity.User;
import com.jeevan.bank.exception.BankException;
import com.jeevan.bank.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BankServiceImpl bankService;

    public UserDto saveUser(UserDto userDto) {
        User user = convertDtoToUser(userDto, false);
        user = userRepo.save(user);
        UserType userType = userDto.getUserType();
        userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setEmail(user.getEmail());
        if (UserType.CUSTOMER.equals(userType)) {
            BankDto bankDto =  new BankDto();
            bankDto.setBankAccNum(user.getBankAccNum());
            bankDto.setUser(user);
            bankDto.setAmount(0D);
            bankDto = bankService.creatBankAccount(bankDto);
            userDto.setBankDto(bankDto);
        }
        return userDto;
    }

    private String generateAccNum() {
        return String.valueOf(System.currentTimeMillis());
    }

    public UserDto updateUser(UserDto userDto) {
        User user = getUserById(userDto.getId());
        user = convertDtoToUser(userDto, true);
        user = userRepo.save(user);
        userDto = convertUserToDto(user);
        return userDto;
    }


    public Boolean deleteUser(Long id) {
        User user = getUserById(id);
        userRepo.delete(user);
        return true;
    }

    public UserDto getUser(Long id) {
        User user = getUserById(id);
        UserDto userDto = convertUserToDto(user);
        return userDto;
    }


    private User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (!user.isPresent())
            throw new BankException("user doesn't exist with the id:" + id);
        return user.get();
    }

    private UserDto convertUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setContact(user.getContact());
        userDto.setStatus(user.getStatus());
        userDto.setUserType(user.getUserType());
        userDto.setBankAccNum(user.getBankAccNum());

        return userDto;

    }

    private User convertDtoToUser(UserDto userDto, Boolean update) {
        User user;
        if (update) {
            user = getUserById(userDto.getId());
            user.setBankAccNum(user.getBankAccNum());
        } else {
            user = new User();
            if(UserType.CUSTOMER.equals(userDto.getUserType()))
                user.setBankAccNum(generateAccNum());
        }
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setContact(userDto.getContact());
        user.setStatus(userDto.getStatus());
        user.setUserType(userDto.getUserType());

        return user;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> userList = new ArrayList<>();
        userRepo.findAll().forEach(user -> {
            UserDto userDto = convertUserToDto(user);
            userList.add(userDto);
        });
        return userList;
    }
}
