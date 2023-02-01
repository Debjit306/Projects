package com.medshop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name= "Customer")

public class Customer extends User {

	@NotNull
	@Column(name="Customer_Name",nullable = false)
	@Size(min=3 , message= "write Your Full Name")
	private String name;
	
	@NotNull
	@Column(name="Customer_Address",nullable = false)
	@Size(min=3 , message= "Write your full address for Delivery purpose")
	private String cusAddress;
	
	@NotNull
	@Column(name="Pincode",nullable = false)
	@Pattern(regexp="^\\d{6}$", message ="Invalid Pincode ")
	@Size(min=6 , message = "Pincode must be contains 6 digits")
	private String pincode;
	
	@NotNull
	@Column(name="Mobile_No.",nullable = false)
	@Pattern(regexp="^\\d{10}$", message ="Invalid Phone Number ")
	@Size(min=10 , message = "Phone Number must be contains 10 digits")
	private String contactNo;
	
	@NotNull
	@Column(name="Email_id",nullable = false)
	@Email(message="Put Your own Email Id")
	private String email; 
	
//	@OneToOne(cascade= CascadeType.ALL)
//	private Cart cart;
	
	@OneToMany
	private List<Cart> cart;
}
