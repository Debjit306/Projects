package com.medshop.service;

import java.util.List;

import com.medshop.entity.Medicine;
import com.medshop.model.MedicineDTO;



public interface MedicineService {
	String createMedicine(Medicine medicine);

	MedicineDTO updateMedicine(int medid, Medicine medicine);

	MedicineDTO getMedicineById(int medid);

	List<MedicineDTO> getAllMedicine();

	String deleteMedicineById(int medid);

	void deleteAllMedicine();

	List<MedicineDTO> getMedicineByName(String medname);
	
	List <MedicineDTO> getMedicineByPrice(double price);
}
