package com.bank.customermanagement.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bank.customermanagement.domain.requests.CustomerRequest;
import com.bank.customermanagement.entity.Customer;
import com.bank.customermanagement.exception.CustomerNotFoundException;
import com.bank.customermanagement.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/add")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerRequest customer) {
		logger.info("Create new Customer: {}",customer.toString());
		 Customer addedCustomer = customerService.addCustomer(customer);
		 URI location = ServletUriComponentsBuilder.fromCurrentServletMapping()
				 .path("/{customerId}")
				 .buildAndExpand(new HashMap<String,String>().put("customerId", Long.toString(addedCustomer.getCustomerId())))
				 .toUri();
		 System.out.println("location"+location.toString());
		return ResponseEntity.created(location).build();
	}
	


	@GetMapping("/{customerId}")
	public Optional<Customer> retrieveCustomer(@PathVariable("customerId") final Long customerId) {
		
		Optional<Customer> retrievedCustomer = customerService.retrieveCustomer(customerId);
		if(!retrievedCustomer.isPresent())
			throw new CustomerNotFoundException("customer_id-"+customerId);
		
		return retrievedCustomer;
		
	}
	@GetMapping("/all")
	public List<Customer> getAll(){
		return customerService.findall();
	}
}

