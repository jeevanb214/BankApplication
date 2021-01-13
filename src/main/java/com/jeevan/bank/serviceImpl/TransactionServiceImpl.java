package com.jeevan.bank.serviceImpl;

import com.jeevan.bank.constant.TransactionStatus;
import com.jeevan.bank.dto.TransactionDto;
import com.jeevan.bank.entity.Bank;
import com.jeevan.bank.entity.Transactions;
import com.jeevan.bank.exception.BankException;
import com.jeevan.bank.repository.BankRepo;
import com.jeevan.bank.repository.TransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionServiceImpl {

    @Autowired
    BankRepo bankRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Transactional
    public TransactionDto deposite(TransactionDto transactionDto) {
        validateDto(transactionDto);
        Bank fromBankAcc = findByBankAccountNum(transactionDto.getFromBankAccNum());
        Bank toBankAcc = findByBankAccountNum(transactionDto.getToBankAccNum());
        fromBankAcc.setAmount(fromBankAcc.getAmount()-transactionDto.getAmount());
        toBankAcc.setAmount(toBankAcc.getAmount()+transactionDto.getAmount());
        bankRepo.save(fromBankAcc);
        bankRepo.save(toBankAcc);
        Transactions transactions =  new Transactions();
        transactions.setAmount(transactionDto.getAmount());
        transactions.setApplicationUsed(transactionDto.getApplicationUsed());
        transactions.setFromBankAccNum(transactionDto.getFromBankAccNum());
        transactions.setToBankAccNum(transactionDto.getToBankAccNum());
        transactions.setTransactionStatus(TransactionStatus.PROCESSED);
        transactionRepo.save(transactions);
        transactionDto = new TransactionDto();
        transactionDto.setFromBankAccNum(fromBankAcc.getBankAccNum());
        transactionDto.setToBankAccNum(transactionDto.getToBankAccNum());
        transactionDto.setAmount(transactionDto.getAmount());
        transactionDto.setYourBalance(fromBankAcc.getAmount());
        transactionDto.setTransactionStatus(TransactionStatus.PROCESSED);
        return transactionDto;
    }

    private void validateDto(TransactionDto transactionDto) {
        Bank bank = findByBankAccountNum(transactionDto.getFromBankAccNum());
        if(bank.getAmount()-transactionDto.getAmount()<0)
            throw new BankException("Insufficient Bank Balance :"+bank.getAmount());
        bank = findByBankAccountNum(transactionDto.getToBankAccNum());
    }

    private Bank findByBankAccountNum(String bankAccNum)
    {
        Bank bank = bankRepo.findBybankAccNum(bankAccNum);
        if(bank == null)
            throw new BankException("Invalid Bank Account Number :"+bankAccNum);
        return bank;
    }

    @Transactional
    public TransactionDto withdraw(TransactionDto transactionDto) {
        Bank fromBankAcc = findByBankAccountNum(transactionDto.getFromBankAccNum());
        if(fromBankAcc.getAmount()-transactionDto.getAmount()<0)
            throw new BankException("Insufficient Bank Balance :"+fromBankAcc.getAmount());
        fromBankAcc.setAmount(fromBankAcc.getAmount()-transactionDto.getAmount());
        bankRepo.save(fromBankAcc);
        Transactions transactions =  new Transactions();
        transactions.setAmount(transactionDto.getAmount());
        transactions.setApplicationUsed(transactionDto.getApplicationUsed());
        transactions.setFromBankAccNum(transactionDto.getFromBankAccNum());
        transactions.setTransactionStatus(TransactionStatus.PROCESSED);
        transactionRepo.save(transactions);
        transactionDto = new TransactionDto();
        transactionDto.setFromBankAccNum(fromBankAcc.getBankAccNum());
        transactionDto.setYourBalance(fromBankAcc.getAmount());
        return transactionDto;
    }
}
