package com.bank.accountmanagment.exception;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8338835261566821777L;

	public AccountNotFoundException(String string) {
		super(string);
	}

}
