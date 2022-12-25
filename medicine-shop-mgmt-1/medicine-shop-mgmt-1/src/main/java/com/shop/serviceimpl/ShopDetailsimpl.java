package com.shop.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.ShopDetails;
import com.shop.model.ShopDetailsDTO;
import com.shop.repository.ShopDetailsRepository;
import com.shop.service.ShopDetailsService;
import com.shop.util.ShopDetailsConverter;

@Service
public class ShopDetailsimpl implements ShopDetailsService{

	@Autowired
	private ShopDetailsRepository shopDetailsRepository;
	
	@Autowired
	private ShopDetailsConverter shopConverter;
	
	@Override
	public String createShopDetails(ShopDetails shopDetails) {
		
		String message = null;
		shopDetailsRepository.save(shopDetails);
		if (shopDetails != null) {
			message = "Shop Details are Saved Successfully";
		}
		return message;
	}

	@Override
	public ShopDetailsDTO getShopDetailsById(int shopid) {
		ShopDetails foundShop = shopDetailsRepository.findById(shopid).get();
		return shopConverter.convertToShopDetailsDTO(foundShop);
		
	}

	@Override
	public List<ShopDetailsDTO> getAllShopDetails() {
		List<ShopDetails> allShopDetailsList = shopDetailsRepository.findAll();

		List<ShopDetailsDTO> allShopDetailsDTOs = new ArrayList<>();

		for (ShopDetails shopDetails : allShopDetailsList) {
			allShopDetailsDTOs.add(shopConverter.convertToShopDetailsDTO(shopDetails));
		}

		return allShopDetailsDTOs;
	}


	@Override
	public String deleteShopDetailsById(int shopid) {
		Optional<ShopDetails> shopDetails = shopDetailsRepository.findById(shopid);

		if (shopDetails.isPresent()) {
			shopDetailsRepository.deleteById(shopid);
			return "Shop Details Are Deleted Successfully :)";
		}

		return "shop Details are Not Found :(";
	}

	@Override
	public List<ShopDetailsDTO> getShopDetailsByBranch(String shopBranch) {
		List<ShopDetails> shopList =shopDetailsRepository.getShopDetailsByBranch(shopBranch);

		List<ShopDetailsDTO> allShopDetailsDTOs = new ArrayList<>();

		for (ShopDetails shopDetails : shopList) {
			allShopDetailsDTOs.add(shopConverter.convertToShopDetailsDTO(shopDetails));
		}

		return allShopDetailsDTOs;
}
	

}
