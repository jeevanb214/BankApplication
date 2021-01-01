package com.jeevan.Bank.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    private String bankAccNum;

    private String email;

    private String firstName;

    private String lastName;

    private String contact;

    //@JsonIgnore
    private String password;

    private String userType;

    private String status;

    private Double amount;

}
