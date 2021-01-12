package com.jeevan.bank.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import com.jeevan.bank.constant.*;

import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    @NotBlank
    private String bankAccNum;

    @NotBlank
    private String email;

    @NotBlank
    private String firstName;

    private String lastName;

    @NotBlank
    private String contact;

    //@JsonIgnore
    private String password;

    @NotBlank
    private UserType userType;

    private String status;

    private Double amount;

}
