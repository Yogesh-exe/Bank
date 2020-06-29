package com.bank.customermanagement.entity.customer;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.customermanagement.domain.mapper.ICustomerRequestEntityMapper;
import com.bank.customermanagement.domain.requests.CustomerRequest;

@Service
public class CustomerService {
	
	private static final String ACCOUNT_SERVICE_ADD_URL = "http://localhost:9070/account/add";

	private ICustomerRequestEntityMapper customerRequestEntityMapper;

	private CustomerRepository customerRepository;

	
	public CustomerService(ICustomerRequestEntityMapper customerRequestEntityMapper,
			CustomerRepository customerRepository) {
		super();
		this.customerRequestEntityMapper = customerRequestEntityMapper;
		this.customerRepository = customerRepository;
	}

	public Customer addCustomer(@Valid CustomerRequest customerRequest)  {

		Customer customer = customerRequestEntityMapper.map(customerRequest);
	
		Integer accountNumber = new RestTemplate().postForObject(ACCOUNT_SERVICE_ADD_URL, customer.getDetails().getMobile(), Integer.class);
		customer.setAccountNumber(accountNumber);
		Customer savedCustomer = customerRepository.save(customer);
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
