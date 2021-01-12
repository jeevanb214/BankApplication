package com.jeevan.bank.dto;

import com.jeevan.bank.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {

    @NotNull
    private User user;

    @NotNull
    private Double amount;

    @NotNull
    private String bankAccNum;


}
