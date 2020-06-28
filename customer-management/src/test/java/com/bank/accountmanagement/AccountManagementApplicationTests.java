package com.bank.accountmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bank.customermanagement.domain.requests.CustomerRequest;
import com.bank.customermanagement.entity.account.Account;
import com.bank.customermanagement.entity.address.Address;
import com.bank.customermanagement.entity.customer.Customer;
import com.bank.customermanagement.entity.customer.CustomerService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@Transactional
class AccountManagementApplicationTests {

	@Autowired
	CustomerService customerService;
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void addCustomer() {
//		
//		Long account =1L;
//		List<Address> address =new ArrayList<>() ;
//		address.add(new Address("2nd","Pune","MH",411028));
//		@Valid CustomerRequest customer = new CustomerRequest("Yogesh","Bagul","abc@gmail.com","9421415833",address);
//		Customer savedCust = customerService.addCustomer(customer);
//		logger.info("customerId"+ savedCust.getCustomerId());
//		
//		
//		Optional<Customer> retrieveCustomer = customerService.retrieveCustomer(1L);
//		logger.info("XXX"+retrieveCustomer.get().toString());
		//assertThat(accountId);
	}

}
