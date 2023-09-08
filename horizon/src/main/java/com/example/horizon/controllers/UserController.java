package com.example.horizon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.horizon.entities.User;
import com.example.horizon.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

		@Autowired
	    private UserService userService;

	    @GetMapping
	    public ResponseEntity<List<User>> getAllUsers() {
	    	return ResponseEntity.ok().body(userService.getAllUsers());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	    	return ResponseEntity.ok().body(userService.getUserById(id));
	    }

	    @PostMapping
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        return ResponseEntity.ok().body(userService.createUser(user));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
	        return ResponseEntity.ok().body(userService.updateUser(id, updatedUser));
	    }

	    @DeleteMapping("/{id}")
	    public boolean deleteUser(@PathVariable Long id) {
	        return userService.deleteUser(id);
	    }
	
}
