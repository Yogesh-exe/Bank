package com.bank.customermanagement.domain.mapper;

import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.customermanagement.domain.requests.CustomerRequest;
import com.bank.customermanagement.entity.customer.Customer;


public class CustomerRequestEntityMapper implements ICustomerRequestEntityMapper {

	@Autowired
	Provider<Customer> customerProvider;

	@Override
	public Customer map(CustomerRequest request) {
		Customer customer =customerProvider.get();
		customer.setDetails(request);
		return customer;
	}

}
