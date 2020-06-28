package com.bank.accountmanagment.entity.account;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNumber;
	
	private BigDecimal balance ;

	public Account() {
		this.balance = BigDecimal.ZERO;
	}
	
	

}
