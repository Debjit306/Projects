package com.shop.service;

import java.util.List;

import com.shop.entity.MedicineDetails;
import com.shop.model.MedicineDetailsDTO;

public interface MedicineDetailsService {
	String createMedicineDetails(MedicineDetails medicineDetails);

	MedicineDetailsDTO updateMedicineDetails(int medid, MedicineDetails medicineDetails);

	MedicineDetailsDTO getMedicineDetailsById(int medid);

	List<MedicineDetailsDTO> getAllMedicineDetails();

	String deleteMedicineDetailsById(int medid);

	void deleteAllMedicineDetails();

	List<MedicineDetailsDTO> getMedicineDetailsByName(String medName);

}
