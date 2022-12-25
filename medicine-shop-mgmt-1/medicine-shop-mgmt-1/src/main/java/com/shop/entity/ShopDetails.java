package com.shop.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="shop_details")
public class ShopDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;
	@Column
	private String shopBranch;
	@Column
	private int shopPincode;
	@Column
	private long shopAvgSale;
	
	
}
