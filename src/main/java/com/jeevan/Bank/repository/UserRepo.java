package com.jeevan.Bank.repository;

import com.jeevan.Bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
