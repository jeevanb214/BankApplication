package com.jeevan.Bank.repository;

import com.jeevan.Bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Long> {
}
