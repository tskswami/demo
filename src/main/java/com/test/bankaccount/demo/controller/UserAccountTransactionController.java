package com.test.bankaccount.demo.controller;

import java.util.List;

import com.test.bankaccount.demo.UserAccountException;
import com.test.bankaccount.demo.model.Account;
import com.test.bankaccount.demo.model.AccountTransaction;
import com.test.bankaccount.demo.model.User;
import com.test.bankaccount.demo.repository.AccountRepository;
import com.test.bankaccount.demo.repository.TransactionRepository;
import com.test.bankaccount.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAccountTransactionController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/user/{userId}/account/{accountId}/transaction")
    public List<AccountTransaction> getAccountTransaction(@PathVariable Long userId, @PathVariable Long accountId) {
        if (!userRepository.findById(userId).isPresent()) {
            throw new UserAccountException(" unknown user");
        }
        if (!accountRepository.findById(accountId).isPresent()) {
            throw new UserAccountException(" unknown account");
        }
        return transactionRepository.findByAccountId(accountId);
    }

    @GetMapping("/user")
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/user/{userId}/account")
    public List<Account> getAccounts(@PathVariable Long userId) {
        if (!userRepository.findById(userId).isPresent()) {
            throw new UserAccountException(" unknown user");
        }
        return accountRepository.findByUserId(userId);
    }

    @PostMapping(path = "/user", consumes = "application/json")
    public void addUser(@RequestBody User user) {


        userRepository.save(user);
    }

    @PostMapping(path = "/user/{userId}/account", consumes = "application/json")
    public void addAccount(@PathVariable Long userId, @RequestBody Account account) {
        if (userRepository.findById(userId).isPresent()) {
            account.setUser(userRepository.findById(userId).get());
            accountRepository.save(account);
        } else {
            throw new UserAccountException(" unknown user");
        }
    }

    @PostMapping(path = "user/{userId}/account/{accountId}/transaction", consumes = "application/json")
    public void addTransaction(@PathVariable Long userId, @PathVariable Long accountId, @RequestBody AccountTransaction accountTransaction) {

        if (userRepository.findById(userId).isPresent()) {
            if (accountRepository.findById(accountId).isPresent()) {
                accountTransaction.setAccount(accountRepository.getOne(accountId));
                transactionRepository.save(accountTransaction);
            } else {
                throw new UserAccountException(" unknown account");
            }

        } else {
            throw new UserAccountException(" unknown user");
        }
    }
}

