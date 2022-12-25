package com.shop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.shop.entity.ShopDetails;
import com.shop.model.ShopDetailsDTO;

@Component
public class ShopDetailsConverter {
	// convert ShopDetailsDTO to Entity(ShopDetails)
	public ShopDetails convertToEntity(ShopDetailsDTO shopDetailsDTO) {

		ShopDetails shopDetails = new ShopDetails();
		if (shopDetailsDTO != null) {
			BeanUtils.copyProperties(shopDetailsDTO, shopDetails);
		}

		return shopDetails;
	}

	// convert Entity(ShopDetails) to ShopDetailsDTO
	public ShopDetailsDTO convertToShopDetailsDTO(ShopDetails shopDetails) {

		ShopDetailsDTO shopDetailsDTO= new ShopDetailsDTO();
		if (shopDetails != null) {
			BeanUtils.copyProperties(shopDetails, shopDetailsDTO);
		}

		return shopDetailsDTO;
	}
}
