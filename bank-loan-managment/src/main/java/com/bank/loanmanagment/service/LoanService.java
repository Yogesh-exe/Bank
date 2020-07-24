package com.bank.loanmanagment.service;

import java.util.Optional;

import com.bank.loanmanagment.domain.request.LoanRequest;
import com.bank.loanmanagment.domain.request.PaymmentRequest;
import com.bank.loanmanagment.domain.request.mapper.LoanRequestEntityMapper;
import com.bank.loanmanagment.entity.Loan;
import com.bank.loanmanagment.repository.LoanRepository;

public class LoanService implements ILoanService {

	private LoanRepository loanRepository;
	private LoanRequestEntityMapper loanRequestEntityMapper;
	
	public LoanService(LoanRepository loanRepository, LoanRequestEntityMapper loanRequestEntityMapper) {
		super();
		this.loanRepository = loanRepository;
		this.loanRequestEntityMapper=loanRequestEntityMapper;
	}

	@Override
	public Optional<Loan> createLoan(LoanRequest request) {
		
		return null;
	}

	@Override
	public Optional<Loan> retriveLoan(LoanRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Loan> payInstallment(PaymmentRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
