package com.horizonbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.horizonbank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {}
