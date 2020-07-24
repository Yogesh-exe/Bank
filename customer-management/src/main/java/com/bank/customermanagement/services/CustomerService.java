package com.bank.customermanagement.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.customermanagement.domain.mapper.ICustomerRequestEntityMapper;
import com.bank.customermanagement.domain.requests.CustomerRequest;
import com.bank.customermanagement.entity.Customer;
import com.bank.customermanagement.repostitories.CustomerRepository;
import com.bank.customermanagement.validations.RequestValidation;

@Service
public class CustomerService {
	
	private static final String ACCOUNT_SERVICE_ADD_URL = "http://localhost:9070/account/add";

	private ICustomerRequestEntityMapper customerRequestEntityMapper;

	private CustomerRepository customerRepository;
	
	private RequestValidation<CustomerRequest> requestValidator;

	@Autowired
	public void setRequestValidator(RequestValidation<CustomerRequest> requestValidator) {
		this.requestValidator = requestValidator;
	}

	public CustomerService(ICustomerRequestEntityMapper customerRequestEntityMapper,
			CustomerRepository customerRepository) {
		super();
		this.customerRequestEntityMapper = customerRequestEntityMapper;
		this.customerRepository = customerRepository;
	}

	public Customer addCustomer(@Valid CustomerRequest customerRequest)  {
		
		requestValidator.validate();

		Customer customer = customerRequestEntityMapper.map(customerRequest);
		customer.setAccountNumber(0);
		Customer savedCustomer = customerRepository.save(customer);
		Integer accountNumber = new RestTemplate().postForObject(ACCOUNT_SERVICE_ADD_URL, savedCustomer.getCustomerId(), Integer.class);
		customer.setAccountNumber(accountNumber);
		 savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}

	public Optional<Customer> retrieveCustomer(Long customerId) {
		
		return customerRepository.findById(customerId);
	}

	public List<Customer> findall() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

}
