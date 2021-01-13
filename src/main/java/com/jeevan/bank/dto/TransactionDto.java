package com.jeevan.bank.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jeevan.bank.constant.ApplicationUsed;
import com.jeevan.bank.constant.TransactionStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {

    @NotNull
    private Double amount;

    @NotNull
    private ApplicationUsed applicationUsed;

    private String toBankAccNum;

    @NotNull
    private String fromBankAccNum;

    private Double yourBalance;

    private TransactionStatus transactionStatus;

}
