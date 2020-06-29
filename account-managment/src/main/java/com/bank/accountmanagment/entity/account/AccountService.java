package com.bank.accountmanagment.entity.account;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bank.accountmanagment.domain.request.AccountRequest;
import com.bank.accountmanagment.domain.request.TransferRequest;
import com.bank.accountmanagment.exception.AccountNotFoundException;

@Service
@Transactional
public class AccountService {


	AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

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
	

	synchronized public int credit(AccountRequest accountRequest) {
		int operationStatus = accountRepository.setBalanceById(accountRequest.getAmount(), accountRequest.getAccountNumber());
		return operationStatus;	
	}

	synchronized public int  debit(AccountRequest accountRequest) {
		int operationStatus = accountRepository.setBalanceById(accountRequest.getAmount(), accountRequest.getAccountNumber());
		return operationStatus;	
	}
	
	synchronized public boolean transfer(TransferRequest transferRequest) {
		boolean operationStatus = (debit(transferRequest.getFrom())==1 && credit(transferRequest.getTo())==1);
		return operationStatus;	
	}

}
