package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="medicine")
public class MedicineDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medid;
	@Column
	private String medName;
	@Column
	private String compositeName;
	@Column
	private double price;
	@Column
	private int qty;
	
	@ManyToOne
	private ShopDetails shopDetails;
}

