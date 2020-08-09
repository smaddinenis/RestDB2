package com.example.RestDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts") // READ operation in CRUD
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{accountId}") // READ operation in CRUD
    public Optional<Account> getAllAccountById(@PathVariable(value="accountId") String accountId) {
        return accountRepository.findById(accountId);
    }

    @PostMapping("/accounts") // CREATE operation in CRUD
    public @Valid Account createEmployee(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }
}
