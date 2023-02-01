package com.medshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medshop.entity.Cart;
import com.medshop.model.CartDTO;

import com.medshop.service.CartService;
import com.medshop.util.CartConverter;


@RestController
@RequestMapping("/api")
public class CartController {
	
	
	
	@Autowired
	private CartConverter cartConverter;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/createOrder/{cartid}")
	public String createOrder(@PathVariable("cartid") int cartid, @RequestBody CartDTO cartDTO) {
		final Cart cart = cartConverter.ConvertToEntity(cartDTO);
		return cartService.createOrder(cart, cartid);
	}

	
	@GetMapping("/getCartById/{cartid}")
	public CartDTO getCartById(@PathVariable("cartid") int cartid) {
		return cartService.getCartById(cartid);
	}

	
	@GetMapping("/getAllCart")
	public List<CartDTO> getAllCart() {
		return cartService.getAllCart();
	}
	
	@PutMapping("/updateCart/{cartid}")
	public CartDTO updateCart(@PathVariable("cartid") int cartid, @RequestBody CartDTO cartDTO) {
		Cart cart = cartConverter.ConvertToEntity(cartDTO);
		return cartService.updateCart(cartid, cart);
	}

	
	@DeleteMapping("/deleteCartById/{cartid}")
	public String deleteCartById(@PathVariable("cartid") int cartid) {
		return cartService.deleteCartById(cartid);
	}

	
	@DeleteMapping("/deleteAllCart")
	public ResponseEntity<String> deleteAllOrders() {
		cartService.deleteAllCart();
		return new ResponseEntity<>("------- ALL CART ITEMS ARE DELETED --------", HttpStatus.OK);
	}
}
