package com.shop.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaymentBillDTO {
	private int billid;
	
	@NotNull
	@Size(min=5)
	private String customerName;
	
	@NotNull
	@Size(min=5)
	private String medicineName;
	
	@NotNull
	@Size(min=5)
	private String shopBranch;
	
	@NotNull
	@Size(min=5)
	private int qty;
	
	@NotNull
	@Size(min=5)
	private double price;
}
