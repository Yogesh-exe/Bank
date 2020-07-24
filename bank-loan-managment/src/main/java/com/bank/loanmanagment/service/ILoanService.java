package com.bank.loanmanagment.service;

import java.util.Optional;

import com.bank.loanmanagment.domain.request.LoanRequest;
import com.bank.loanmanagment.domain.request.PaymmentRequest;
import com.bank.loanmanagment.entity.Loan;

public interface ILoanService {
	
	public Optional<Loan> createLoan(LoanRequest request);
	public Optional<Loan> retriveLoan(LoanRequest request);
	public Optional<Loan> payInstallment(PaymmentRequest request);

}
