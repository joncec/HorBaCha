package com.horizonbank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.horizonbank")
@SpringBootApplication
public class HorizonBankApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(HorizonBankApplication.class, args);
	}
}