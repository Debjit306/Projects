package com.medshop.model;

import java.util.Date;

import com.medshop.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MedicineDTO {
	private int medid;
	private String medname;
	private String componame;
	private Date mfgDate;
	private Date expDate;
	private int qtyavailable;
	private double price;
	private String img;
	private Cart cart;
}
