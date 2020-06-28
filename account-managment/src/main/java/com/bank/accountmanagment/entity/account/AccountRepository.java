package com.bank.accountmanagment.entity.account;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Modifying
	@Query("UPDATE Account A SET A.balance = A.balance + ?1 WHERE A.accountNumber= ?2")
	public boolean setBalanceById(BigDecimal balance,Integer AccountId);
}
