package com.jeevan.Bank.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {

    private Double amount;

    private String applicationUsed;

    private Long toBankAccNum;

    private Long fromBankAccNum;

}
