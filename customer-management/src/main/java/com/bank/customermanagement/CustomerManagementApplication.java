package com.bank.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.customermanagement.domain.mapper.CustomerRequestEntityMapper;

@SpringBootApplication
public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}

	@Bean
	public CustomerRequestEntityMapper customerRequestEntityMapperbean() {
		return new CustomerRequestEntityMapper(); 
	}
}
