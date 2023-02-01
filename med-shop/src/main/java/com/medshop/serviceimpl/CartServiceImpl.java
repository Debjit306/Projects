package com.medshop.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medshop.entity.Cart;
import com.medshop.entity.Customer;
import com.medshop.entity.Medicine;
import com.medshop.exception.ResourceNotFoundException;
import com.medshop.model.CartDTO;
import com.medshop.repository.CartRepository;
import com.medshop.repository.CustomerRepository;
import com.medshop.service.CartService;
import com.medshop.util.CartConverter;

@Service
public class CartServiceImpl implements CartService {
	private static final Logger l = LoggerFactory.getLogger(Cart.class);
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartConverter cartConverter;
	
	private Medicine medicine;
	
	
	@Override
	public String createOrder(Cart cart, int cartid) {
double price= medicine.getPrice();
		
		
		int qty = cart.getOrderQty();
		
		int qtyavailabale = medicine.getQtyavailable() - cart.getOrderQty();
		 
		double totalprice = price*qty;
		
		cart.setOrderPrice(totalprice);
		 
		medicine.setQtyavailable(qtyavailabale);
		 
		Customer foundcustomer= customerRepository.findById(cartid).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",cartid));
			
		List<Cart> allCart = foundcustomer.getCart();
			
		allCart.add(cart);
		
		cart.setCustomer(foundcustomer);
		l.info("Admin "+cart.toString()+" added at "+ new Date());
		customerRepository.save(foundcustomer);
		
		if (cart!= null) {
		
			return "order Saved----------";
				
			}
			
			return "Request to you Try again----------";
	}

	@Override
	public CartDTO getCartById(int cartid) {
		Cart foundCart = cartRepository.findById(cartid).orElseThrow(() ->
		 new ResourceNotFoundException("Cart", "Id", cartid)
	);

	l.info("Getting cart details with ID "+cartid+" at "+new Date());
	return cartConverter.ConvertToCartDTO(foundCart);
	}

	@Override
	public List<CartDTO> getAllCart() {
		List<Cart> allCartList = cartRepository.findAll();

		List<CartDTO> allCartDTOs = new ArrayList<>();
		
		for (Cart cart : allCartList) {
			
			allCartDTOs.add(cartConverter.ConvertToCartDTO(cart));
		}

		
		return allCartDTOs;
	}

	@Override
	public CartDTO updateCart(int cartid, Cart cart) {
		Cart foundCart = cartRepository.findById(cartid).orElseThrow(()->
		new ResourceNotFoundException("Cart","Id",cartid)	);
	
	double price= medicine.getPrice();
	
	int qty= cart.getOrderQty();
	
	int qtyavailabale = medicine.getQtyavailable() - cart.getOrderQty();
	 
	double totalprice = price*qty;
	
	cart.setOrderPrice(totalprice);
	 
	medicine.setQtyavailable(qtyavailabale);
	
	foundCart.setOrderName(cart.getOrderName());
	foundCart.setOrderPrice(medicine.getPrice());
	foundCart.setOrderQty(cart.getOrderQty());
	
	cartRepository.save(foundCart);
	l.info("Getting cart details with ID "+cartid+" at "+new Date());
	return cartConverter.ConvertToCartDTO(foundCart);
	}

	@Override
	public String deleteCartById(int cartid) {
Optional<Cart> order = cartRepository.findById(cartid);

		
		if (order.isPresent()) {
			
			cartRepository.deleteById(cartid);
			
			return "------- ORDER DELETED SUCCESSFULLY -------";
		}

		l.info("Getting cart details with ID "+cartid+" at "+new Date());
		return "------- ORDER NOT FOUND -------";
	}

	@Override
	public void deleteAllCart() {
		cartRepository.deleteAll();
		
	}

}
