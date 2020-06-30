package com.bank.accountmanagment.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNumber;
	
	@NotNull
	private Long customerId;
	
	private BigDecimal balance ;

	public Account() {
		this.balance = BigDecimal.ZERO;
	}

	public Account(@NotNull Long customerId) {
		this();
		this.customerId = customerId;
	}
	
	

}
