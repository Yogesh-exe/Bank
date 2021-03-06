package com.bank.accountmanagment.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountmanagment.domain.request.AccountRequest;
import com.bank.accountmanagment.entity.Account;
import com.bank.accountmanagment.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	
	private AccountService accountService;
	
	Logger logger = LoggerFactory.getLogger(AccountController.class); 

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping("/add")
	public Integer addAccount(@RequestBody Long customerId ) {
		logger.info("Entering addAccount");
		Account account = new Account(customerId);
		 Integer addAccount = accountService.addAccount(account);
		 return addAccount;
	}
	
	@GetMapping("/{accountId}")
	public Account getAccountDetails(@PathVariable Integer accountId) {
		 Account account = accountService.getAccount(accountId);
	return account;
	}
	
	@PutMapping(value ="/credit",consumes = "application/json", produces = "application/json")
	public int creditIntoAccount(@RequestBody @Valid AccountRequest accountRequest) {
	int done = accountService.credit(accountRequest);
	ResponseEntity.ok();
		return done;
	}
	@PutMapping(value = "/debit",consumes = "application/json", produces = "application/json")
	public int debitFromAccount(@RequestBody AccountRequest accountRequest) {
		
		return accountService.debit(accountRequest);
	}
	
	@GetMapping("/hello")
	public String hello() {
		 
	return "HELLO";
	}
}
