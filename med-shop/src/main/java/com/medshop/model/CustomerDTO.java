package com.medshop.model;

import com.medshop.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO extends UserDTO {
	private String CustomerName;
	private String cusAddress;
	private String pincode;
	private String contactNo;
	private String CustomerEmail;
	private Cart cart;
}
