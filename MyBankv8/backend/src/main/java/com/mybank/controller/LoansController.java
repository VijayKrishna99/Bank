package com.mybank.controller;


import com.mybank.model.Customer;
import com.mybank.model.Loans;
import com.mybank.repository.CustomerRepository;
import com.mybank.repository.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        final Logger logger = LoggerFactory.getLogger(LoansController.class);
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        logger.info("Loans: {}", loans);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }
}
