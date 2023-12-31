package com.example.horizon.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.horizon.entities.Account;
import com.example.horizon.exceptions.ResourceNotFoundException;
import com.example.horizon.repositories.AccountRepository;

@Service
public class AccountService 
{
	@Autowired
    private  AccountRepository accountRepository;
 
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    public Account getAccountById(Long id) {
    return accountRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account depositToAccount(Long id, BigDecimal amount) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            // Perform deposit logic, update balance
            BigDecimal currentBalance = account.getBalance();
            BigDecimal updatedBalance = currentBalance.add(amount);
            account.setBalance(updatedBalance);
            return accountRepository.save(account);
        }
        return null;
    }

    public Account withdrawFromAccount(Long id, BigDecimal amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
    
        BigDecimal currentBalance = account.getBalance();
        if (currentBalance.compareTo(amount) >= 0) {
            BigDecimal updatedBalance = currentBalance.subtract(amount);
            account.setBalance(updatedBalance);
            return accountRepository.save(account);
        } else {
            throw new IllegalArgumentException("Insufficient balance.");
        }
    }

    public BigDecimal checkAccountBalance(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId));
        return account.getBalance();
    }
}
