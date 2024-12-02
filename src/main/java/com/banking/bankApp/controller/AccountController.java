package com.banking.bankApp.controller;

import com.banking.bankApp.model.Account;
import com.banking.bankApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber){
        return accountService.getAccountByNumber(accountNumber);
    }
    @PutMapping("/{accountNumber}/deposit")
    public Account deposit(@PathVariable String accountNumber,@RequestParam double amount){
        return accountService.deposit(accountNumber,amount);


    }
    @PutMapping("/{accountNumber}/withdraw")
    public Account withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        return accountService.Withdraw(accountNumber,amount);
    }
}
