package com.jeevan.bank.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import com.jeevan.bank.constant.*;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    private String bankAccNum;

    //@NotBlank --> it will not check for the null, it will check only length > 0
    @NotNull
    private String email;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private String contact;

    //@JsonIgnore
    private String password;

    @NotNull
    private UserType userType;

    private String status;

    private Double amount;

    private BankDto bankDto;

}
