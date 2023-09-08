package com.example.horizon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.horizon.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}