package com.shop.model;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.shop.entity.ShopDetails;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MedicineDetailsDTO {
	private int medid;
	
	@NotNull
	@Size(min=5)
	private String medName;
	
	@NotNull
	@Size(min=5)
	private String compositeName;
	
	@NotNull
	@Size(min=5)
	private double price;
	
	@NotNull
	private int qty;
	
	@NotNull
	@Size(min=5)
	 private ShopDetails shopDetails;
}
