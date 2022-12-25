package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.ShopDetails;
import com.shop.model.ShopDetailsDTO;
import com.shop.service.ShopDetailsService;
import com.shop.util.ShopDetailsConverter;

@RestController

public class ShopDetailsController {
	
	@Autowired
	private ShopDetailsService shopService;
	
	@Autowired
	private ShopDetailsConverter shopConverter;
	
	@PostMapping("/createshop")
	public String createShopDetails(@RequestBody ShopDetailsDTO shopDetailsDTO) {

		final ShopDetails shopDetails = shopConverter.convertToEntity(shopDetailsDTO);
		
		return shopService.createShopDetails(shopDetails);
		}
	
	@GetMapping("/getShopDetailsById/{shopid}")
	public ShopDetailsDTO getShopDetailsById(@PathVariable("shopid") int shopid) {

		return shopService.getShopDetailsById(shopid);
	}
	
	@GetMapping("/getAllShopDetails")
	public List<ShopDetailsDTO> getAllShopDetails() {
		return shopService.getAllShopDetails();
	}
	
	@DeleteMapping("/deletShopDetailsById/{shopid}")
	public String deleteShopDetailsById(@PathVariable("shopid") int shopid) {
		return shopService.deleteShopDetailsById(shopid);
	}
	
	@GetMapping("/getShopDetailsByBranch/{branch}")
	public List<ShopDetailsDTO> getShopDetailsByBranch(@PathVariable("branch") String shopBranch) {

		return shopService.getShopDetailsByBranch(shopBranch);
	}
}
