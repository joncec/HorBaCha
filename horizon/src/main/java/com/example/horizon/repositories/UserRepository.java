package com.example.horizon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.horizon.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {}
