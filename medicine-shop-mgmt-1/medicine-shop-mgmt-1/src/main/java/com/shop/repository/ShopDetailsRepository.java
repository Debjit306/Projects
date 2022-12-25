package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.ShopDetails;


public interface ShopDetailsRepository extends JpaRepository<ShopDetails,Integer> {
	@Query("from ShopDetails where lower(shopBranch) like :b%")
	List<ShopDetails> getShopDetailsByBranch(@Param("b") String shopBranch);
	
	@Query("from ShopDetails where pincode=:e ")
	List<ShopDetails> getShopDetailsBypincode(@Param("e") int pincode);
}
