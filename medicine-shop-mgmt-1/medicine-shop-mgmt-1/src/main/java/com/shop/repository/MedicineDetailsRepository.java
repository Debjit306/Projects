package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.MedicineDetails;


public interface MedicineDetailsRepository extends JpaRepository<MedicineDetails,Integer> {

	@Query("from MedicineDetails where lower(medName) like :m%")
	List<MedicineDetails> getMedicineDetailsByName(@Param("m") String medName);
	
	@Query("from MedicineDetails where price=:p ")
	List<MedicineDetails> getMedicineDetailsByprice(@Param("p") double price);
}
