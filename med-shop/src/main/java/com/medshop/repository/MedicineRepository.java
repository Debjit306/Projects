package com.medshop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medshop.entity.Medicine;



public interface MedicineRepository extends JpaRepository<Medicine, Integer>{
List<Medicine> getMedicineByPrice (double price);
	
	List <Medicine> findByExpDate (Date expDate);

	public List<Medicine> getMedicineByMedname(String medname);
	
	List<Medicine> findByMedid(int medid);
}
