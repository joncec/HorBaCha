package com.example.horizon;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.horizon.entities.User;
import com.example.horizon.repositories.UserRepository;

@SpringBootApplication
public class HorizonApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;  
	
	public static void main(String[] args) {
		SpringApplication.run(HorizonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "ROBERTO", "31323131", "31223131");
		User u2 = new User(null, "ROBERTO", "31323131", "31223131");
		User u3 = new User(null, "ROBERTO", "31323131", "31223131");
		 
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
