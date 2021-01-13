package com.jeevan.bank.repository;

import com.jeevan.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Long> {

    Bank findBybankAccNum(String bankAccountNum);

}
