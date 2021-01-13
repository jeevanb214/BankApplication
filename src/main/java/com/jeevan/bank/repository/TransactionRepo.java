package com.jeevan.bank.repository;

import com.jeevan.bank.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {
}
