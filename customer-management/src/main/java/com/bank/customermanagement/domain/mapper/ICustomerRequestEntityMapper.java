package com.bank.customermanagement.domain.mapper;

import org.springframework.stereotype.Component;

import com.bank.customermanagement.domain.requests.CustomerRequest;
import com.bank.customermanagement.entity.Customer;

@Component
public interface ICustomerRequestEntityMapper {
	
	public Customer map(final CustomerRequest request);

}
