package com.jeevan.bank.controller;

import com.jeevan.bank.dto.TransactionDto;
import com.jeevan.bank.dto.response.ApiResponse;
import com.jeevan.bank.entity.Bank;
import com.jeevan.bank.exception.BankException;
import com.jeevan.bank.serviceImpl.TransactionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionService;


    @PostMapping("/deposite")
    public ApiResponse deposite(@RequestBody @Valid TransactionDto transactionDto) throws Exception {
        ApiResponse<TransactionDto> apiResponse = new ApiResponse<>();
        try {
            transactionDto = transactionService.deposite(transactionDto);
            apiResponse.setResultData(transactionDto);
            apiResponse.setMessage("transaction is successful");
            apiResponse.setSuccess(true);
        } catch (BankException bankException) {
            throw new BankException(bankException);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
        return apiResponse;
    }

    @PostMapping("/withdraw")
    public ApiResponse withdraw(@RequestBody @Valid TransactionDto transactionDto) throws Exception {
        ApiResponse<TransactionDto> apiResponse = new ApiResponse<>();
        try {
            transactionDto = transactionService.withdraw(transactionDto);
            apiResponse.setResultData(transactionDto);
            apiResponse.setMessage("transaction is successful");
            apiResponse.setSuccess(true);
        } catch (BankException bankException) {
            throw new BankException(bankException);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
        return apiResponse;
    }
}
