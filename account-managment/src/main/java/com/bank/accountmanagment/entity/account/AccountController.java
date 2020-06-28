package com.bank.accountmanagment.entity.account;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountmanagment.domain.request.AccountRequest;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping("/add")
	public Integer addAccount(@RequestBody String mobile ) {
		Account account = new Account();
		 Integer addAccount = accountService.addAccount(account);
		 return addAccount;
	}
	
	@GetMapping("/{accountId}")
	public Account getAccountDetails(@PathVariable Integer accountId) {
		 Account account = accountService.getAccount(accountId);
	return account;
	}
	
	@PutMapping(value ="/credit",consumes = "application/json", produces = "application/json")
	public boolean creditIntoAccount(@RequestBody @Valid AccountRequest accountRequest) {
		
		return accountService.credit(accountRequest);
	}
	@PutMapping(value = "/debit",consumes = "application/json", produces = "application/json")
	public boolean debitFromAccount(@RequestBody AccountRequest accountRequest) {
		
		return accountService.debit(accountRequest);
	}
	
	@GetMapping("/hello")
	public String hello() {
		 
	return "HELLO";
	}
}
