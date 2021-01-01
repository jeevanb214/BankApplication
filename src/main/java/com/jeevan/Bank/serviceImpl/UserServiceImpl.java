package com.jeevan.Bank.serviceImpl;

import com.jeevan.Bank.dto.UserDto;
import com.jeevan.Bank.entity.User;
import com.jeevan.Bank.repository.UserRepo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;

    public UserDto saveUser(UserDto userDto) {

        User user = convertDtoToUser(userDto, false);

        user = userRepo.save(user);

        userDto = new UserDto();
        userDto.setBankAccNum(user.getBankAccNum());
        return userDto;
    }

    private String generateAccNum() {
        return String.valueOf(System.currentTimeMillis());
    }

    @SneakyThrows
    public UserDto updateUser(UserDto userDto) {

        if (userDto.getId() == null)
            throw new Exception("user doesn't exist");
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


    @SneakyThrows
    private User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (!user.isPresent())
            throw new Exception("user doesn't exist");

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
        if (update)
            user = getUserById(userDto.getId());
        else
            user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setContact(userDto.getContact());
        user.setStatus(userDto.getStatus());
        user.setUserType(userDto.getUserType());
        user.setBankAccNum(generateAccNum());

        return user;
    }
}
