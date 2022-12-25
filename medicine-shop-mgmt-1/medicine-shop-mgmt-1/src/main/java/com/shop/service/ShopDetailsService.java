package com.shop.service;

import java.util.List;

import com.shop.entity.ShopDetails;
import com.shop.model.ShopDetailsDTO;


public interface ShopDetailsService {
	String createShopDetails(ShopDetails ShopDetails);

	ShopDetailsDTO getShopDetailsById(int shopid);
	
	List<ShopDetailsDTO> getAllShopDetails();
	
	String deleteShopDetailsById(int shopid);
	
	List<ShopDetailsDTO> getShopDetailsByBranch(String shopBranch);
}
