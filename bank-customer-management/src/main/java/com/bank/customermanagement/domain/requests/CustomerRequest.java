package com.bank.customermanagement.domain.requests;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.bank.customermanagement.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerRequest {


	@Column(length = 25)
	@Size(min = 2, max=25,message = "First Name length must be between 2 & 25")
	private String firstName;
	
	@Column(length = 25)
	@Size(min = 2, max=25)
	private String lastName;
	
	@Column(length = 110)
	private String email;
	
	@Column(length = 10)
	private String mobile;


	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private List<Address> address;

//	public CustomerRequest(String firstName,
//			String lastName, String email, String mobile, List<Address> address) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.mobile = mobile;
//		this.address = address;
//	}

}
