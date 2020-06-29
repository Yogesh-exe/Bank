package com.bank.accountmanagment.entity.account;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Modifying
	@Query("update Account a set a.balance = a.balance + ?1 where a.accountNumber= ?2")
	public int setBalanceById(BigDecimal balance,Integer AccountId);
}
