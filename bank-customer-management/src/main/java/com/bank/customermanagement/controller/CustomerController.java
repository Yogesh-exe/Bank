package com.bank.customermanagement.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return new ResponseEntity<Customer>(addedCustomer,HttpStatus.CREATED);
	}
	


	@GetMapping("/{customerId}")
	public EntityModel<Customer> retrieveCustomer(@PathVariable("customerId") final Long customerId) {
		
		Customer retrievedCustomer = customerService.retrieveCustomer(customerId)
											.orElseThrow(()-> new CustomerNotFoundException(customerId));
	
		return EntityModel.of(retrievedCustomer,
				linkTo(methodOn(CustomerController.class).retrieveCustomer(customerId)).withSelfRel());
		
	}
	
	@PutMapping("/{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") final Long customerId, @RequestBody CustomerRequest customerRequest) {		
		return customerService.updateCustomer(customerId, customerRequest);
		
	}
	
	@GetMapping("/all")
	public List<Customer> getAll(){
		return customerService.findall();
	}
}

