package com.bank.loanmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.loanmanagment.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
