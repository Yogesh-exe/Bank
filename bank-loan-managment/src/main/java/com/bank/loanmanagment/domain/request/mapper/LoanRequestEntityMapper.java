package com.bank.loanmanagment.domain.request.mapper;

import javax.inject.Provider;

import org.springframework.stereotype.Component;

import com.bank.loanmanagment.domain.request.LoanRequest;
import com.bank.loanmanagment.entity.Loan;

@Component
public class LoanRequestEntityMapper {
	
	Provider<Loan> loanprovider;
	
	private Loan map(LoanRequest loanRequest) {
		
		Loan loan = loanprovider.get();
		return loan;
	}

}
