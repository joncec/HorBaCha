package com.example.horizon.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.horizon.entities.Account;
import com.example.horizon.exceptions.ResourceNotFoundException;
import com.example.horizon.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> depositToAccount(@PathVariable Long id, @RequestParam BigDecimal amount) {
        try {
            Account updatedAccount = accountService.depositToAccount(id, amount);
            if (updatedAccount != null) {
                return ResponseEntity.ok(updatedAccount);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/balance")
    public BigDecimal checkAccountBalance(@PathVariable Long id) {
        return accountService.checkAccountBalance(id);
    }

    public Account withdrawFromAccount(@PathVariable Long id, @RequestParam BigDecimal amount) {
    try {
        Account updatedAccount = accountService.withdrawFromAccount(id, amount);
        if (updatedAccount != null) {
            return updatedAccount;
        } else {
            throw new ResourceNotFoundException("Account not found with id " + id);
        }
    } catch (IllegalArgumentException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
    }
}



}
