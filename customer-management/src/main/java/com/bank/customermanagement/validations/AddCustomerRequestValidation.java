package com.bank.customermanagement.validations;

import com.bank.customermanagement.domain.requests.CustomerRequest;

public class AddCustomerRequestValidation extends RequestValidation<CustomerRequest> {

	@Override
	public boolean mandatoryChecks() {
		if(null==request.getAddress())
			return false;
		return true;
	}

	@Override
	public boolean optionalChecks() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean commonChecks() {
		// TODO Auto-generated method stub
		return true;
	}

}
