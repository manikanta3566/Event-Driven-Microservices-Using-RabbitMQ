package com.practice.AccountService.controller;

import com.practice.AccountService.DTO.AccountRequestDto;
import com.practice.AccountService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<String> createAccount(@RequestBody AccountRequestDto accountRequestDto){
        return new ResponseEntity<>(accountService.createAccount(accountRequestDto), HttpStatus.CREATED);
    }
}
