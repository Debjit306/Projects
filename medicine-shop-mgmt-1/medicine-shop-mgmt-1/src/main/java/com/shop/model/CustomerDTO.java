package com.shop.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomerDTO {
	private int cusid;
	
	@NotNull
	@Size(min=5)
	private String customerName;
	
	@NotNull
	@Size(min=10, max= 10)
	private long contactNo;
	
	@NotNull
	@Size(min=5)
	private String cusAddress;
	
	@Email
	@NotNull
	private String cusEmailId;
}
