package com.medshop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.medshop.entity.Cart;
import com.medshop.model.CartDTO;



@Component
public class CartConverter {
	public Cart ConvertToEntity(CartDTO cartDTO)
	{
		Cart cart = new Cart();
		if (cartDTO !=null) 
		{
			BeanUtils.copyProperties(cartDTO,cart);
		}
		return cart;
	}
	public CartDTO ConvertToCartDTO(Cart cart)
	{
		CartDTO cartDTO = new CartDTO();
		if (cart !=null) 
		{
			BeanUtils.copyProperties(cart,cartDTO);
		}
		return cartDTO;
	}
}
