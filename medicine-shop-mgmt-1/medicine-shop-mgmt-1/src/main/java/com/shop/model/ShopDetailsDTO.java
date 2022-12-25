package com.shop.model;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;






@Getter
@Setter
public class ShopDetailsDTO {
	private int shopid;
	
	@NotNull
	@Size(min=5)
	private String shopBranch;
	
	@NotNull
	@Size(min=6, max=6)
	private  int shopPincode;
	
	@NotNull
	@Size(min=5)
	private long shopAvgSale;
	
	
	
}
