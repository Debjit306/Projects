package com.medshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



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

@Entity
@Table(name="Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;

	@Column(name = "order_name")
	private String orderName;

	@Column(name = "order_price")
	private double orderPrice;

	@Column(name = "order_quantity")
	private int orderQty;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="med_id")
	private List<Medicine> medicine;
	
	@ManyToOne
	private Customer customer;
	
	@Builder
	public Cart(String orderName, double orderPrice , int orderQty, Medicine medicine) {
		this.orderName= orderName;
		this.orderPrice= orderPrice;
		this.orderQty= orderQty;
		
	}
}
