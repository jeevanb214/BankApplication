package com.jeevan.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("bankController")
public class BankController {

    @GetMapping("check")
    public String checkController(){
        return "Check";
    }



}
