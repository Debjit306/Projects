package com.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment")
public class PaymentBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billid;
	
	
	@Column
	private String customerName;
	
	
	@Column
	private String medicineName;
	
	@Column
	private String shopBranch;
	
	@Column
	private int qty;
	
	@Column
	private double price;
	
	
}
