package com.bank.accountmanagment.domain.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
	
	enum Source{
		BANK,
		NET_BANKING,
		TRANSFER,
		ATM,
		POS
	}
	
	@NotNull
	private Integer accountNumber;
	
	@NotNull
	private Source source;
	
	@NotNull
	private BigDecimal amount;

}
