package com.banking.bankApp.service;

import com.banking.bankApp.model.Account;
import com.banking.bankApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    public Account getAccountByNumber (String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }
    public Account deposit(String accountNumber, double amount){
       Account account = getAccountByNumber(accountNumber);
       if(account !=null){
           account.setBalance(account.getBalance()+amount);
           return accountRepository.save(account);
       }
        return null;
    }
    public Account Withdraw (String accountNumber, double amount){
        Account account = getAccountByNumber(accountNumber);
        if(account!=null && account.getBalance() >=amount){
            account.setBalance(account.getBalance()-amount);
            return accountRepository.save(account);
        }
        return null;
    }

}
