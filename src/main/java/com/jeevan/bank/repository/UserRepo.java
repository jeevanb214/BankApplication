package com.jeevan.bank.repository;

import com.jeevan.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
