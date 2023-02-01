package com.medshop.service;

import java.util.List;

import com.medshop.entity.Cart;
import com.medshop.model.CartDTO;



public interface CartService {
String createOrder(Cart cart, int cartid);
	
	CartDTO getCartById(int cartid);
	
	List<CartDTO> getAllCart();
	
//	List<CartDTO> getCartGreaterThanPrice(double price);
//	
//	List<CartDTO> getCartLessThanPrice(double price);
//	
//	List<CartDTO> getCartBetweenPrice(double maxPrice, double minPrice);
	
	CartDTO updateCart(int cartid, Cart cart);
	
	String deleteCartById(int cartid);
	
	void deleteAllCart();
}
