package com.mybank.controller;


import com.mybank.model.Accounts;
import com.mybank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/myAccount")
    public Accounts getAccount(@RequestParam int id) {
        Accounts accounts = accountRepository.findByCustomerId(id);

        return accounts;
    }
}
