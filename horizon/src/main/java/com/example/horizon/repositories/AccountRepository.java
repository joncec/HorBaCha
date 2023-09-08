package com.example.horizon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.horizon.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
