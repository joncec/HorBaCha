package com.example.horizon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.horizon.entities.Transaction;
import com.example.horizon.services.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	

		@Autowired
	    private TransactionService transactionService;

	    @GetMapping
	    public List<Transaction> getAllTransactions() {
	        return transactionService.getAllTransactions();
	    }

	    @GetMapping("/{id}")
	    public Transaction getTransactionById(@PathVariable Long id) {
	        return transactionService.getTransactionById(id);
	    }

	    @PostMapping
	    public Transaction createTransaction(@RequestBody Transaction transaction) {
	        return transactionService.createTransaction(transaction);
	    }

	


}
