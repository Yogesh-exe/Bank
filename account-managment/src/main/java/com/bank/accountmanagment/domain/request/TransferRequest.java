package com.bank.accountmanagment.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
	
	private AccountRequest from;
	private AccountRequest to;

}
