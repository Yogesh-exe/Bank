package com.bank.loanmanagment.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.loanmanagment.domain.request.LoanRequest;
import com.bank.loanmanagment.entity.Loan;
import com.bank.loanmanagment.service.ILoanService;

@RestController
public class LoanController {
	
	//create loan
	//get details
	//pay installment
	//autopay
	
	private ILoanService LoanService;
	
	@Autowired
	public LoanController(ILoanService service) {
		this.LoanService = service;
	}


	@PostMapping
	public ResponseEntity<Loan> createLoan(@Valid @RequestBody LoanRequest request){
		Optional<Loan> createdLoan = LoanService.createLoan(request);
		return ResponseEntity.ok(createdLoan.get());
		
	}

}
