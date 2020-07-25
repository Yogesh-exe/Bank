package com.bank.customermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7122860871081747752L;

	public CustomerNotFoundException(Long customerId) {
		super(Long.toString(customerId));
		// TODO Auto-generated constructor stub
	}
	
	

}
