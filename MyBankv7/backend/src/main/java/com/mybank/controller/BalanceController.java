package com.mybank.controller;


import com.mybank.model.AccountTransactions;
import com.mybank.repository.AccountTransactionsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;

    public BalanceController(AccountTransactionsRepository accountTransactionsRepository) {
        this.accountTransactionsRepository = accountTransactionsRepository;
    }

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalance(@RequestParam int id) {
        List<AccountTransactions>accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        return accountTransactions;
    }
}
