package com.bank.accountmanagment.entity.account;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

import com.bank.accountmanagment.domain.request.AccountRequest;
import com.bank.accountmanagment.domain.request.TransferRequest;
import com.bank.accountmanagment.exception.AccountNotFoundException;

@Service
@Transactional
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public Integer addAccount(Account account) {
		Account savedAccount = accountRepository.save(account);
		return savedAccount.getAccountNumber();
	}

	public Account getAccount(Integer accountId) {
		Optional<Account> account = accountRepository.findById(accountId);
		 if(account.isPresent()) {
		
//			 EntityModel<Account> accountres= EntityModel.of(account.get());
//			 ControllerLinkBuilder linksTo = 
//					 ControllerLinkBuilder.linkTo(this.credit(accountRequest), parameters)
//			 
			 return account.get();
		 
		 }
		 else {
			throw new AccountNotFoundException("Account Number"+accountId);
		}		
	}
	

	synchronized public boolean credit(AccountRequest accountRequest) {
		boolean operationStatus = accountRepository.setBalanceById(accountRequest.getAmount(), accountRequest.getAccountNumber());
		return operationStatus;	
	}

	synchronized public boolean  debit(AccountRequest accountRequest) {
		boolean operationStatus = accountRepository.setBalanceById(accountRequest.getAmount(), accountRequest.getAccountNumber());
		return operationStatus;	
	}
	
	synchronized public boolean transfer(TransferRequest transferRequest) {
		boolean operationStatus = (debit(transferRequest.getFrom()) && credit(transferRequest.getTo()));
		return operationStatus;	
	}

}
