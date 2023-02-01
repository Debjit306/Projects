package com.medshop.model;

import com.medshop.entity.Medicine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
	private int cartId;
	private String orderName;
	private double orderPrice;
	private int orderQty;
	private Medicine medicine;
}
