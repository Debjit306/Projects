package com.medshop.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name="medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int medid;
	
	@Column(name="Medicine_Name",nullable= false)
	private String medname;
	
	@Column(name="Composition_Name",nullable= false)
	private String componame;
	
	
	@Column(name="Manufacture_date",nullable= false)
	@JsonFormat(pattern="MM-yyyy")
	private Date mfgDate;
	
	@Column(name="Expiary_date",nullable= false)
	@JsonFormat(pattern="MM-yyyy")
	private Date expDate;
	
	@Column(name="Quantity",nullable= false)
	private int qtyavailable;
	
	@Column(name="Price",nullable= false)
	private double price;
	
	@Column (name= "Image", nullable= false)
	private String img;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Cart cart;
}
