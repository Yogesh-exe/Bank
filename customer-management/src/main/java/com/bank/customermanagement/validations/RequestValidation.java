package com.bank.customermanagement.validations;

import javax.validation.ValidationException;

public abstract class RequestValidation<T> {
	
	T request;
	
	public abstract boolean mandatoryChecks();
	public abstract boolean optionalChecks();
	public abstract boolean commonChecks();
	public  boolean validate() {
		if( mandatoryChecks()&&optionalChecks()&&commonChecks())
			return true;
		throw new ValidationException();
	}
}
