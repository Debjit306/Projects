package com.shop.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.Exception.ResourceNotFoundException;
import com.shop.entity.Customer;
import com.shop.entity.MedicineDetails;

import com.shop.model.MedicineDetailsDTO;
import com.shop.repository.MedicineDetailsRepository;
import com.shop.service.MedicineDetailsService;
import com.shop.util.MedicineDetailsConverter;

@Service
public class MedicineDetailsimpl implements MedicineDetailsService{

	@Autowired
	private MedicineDetailsRepository medicineDetailsRepository;
	@Autowired
	private MedicineDetailsConverter medConverter;
	
	
	@Override
	public String createMedicineDetails(MedicineDetails medicineDetails) {
		
		String message = null;
		medicineDetailsRepository.save(medicineDetails);
		if (medicineDetails != null) {
			message = "Medicine Details are Saved Successfully";
		}
		return message;
	}

	@Override
	public MedicineDetailsDTO updateMedicineDetails(int medid, MedicineDetails medicineDetails) {
		MedicineDetails foundMedicine = medicineDetailsRepository.findById(medid).get();

		foundMedicine.setMedName(medicineDetails.getMedName());
		foundMedicine.setCompositeName(medicineDetails.getCompositeName());
		foundMedicine.setPrice(medicineDetails.getPrice());
		foundMedicine.setQty(medicineDetails.getQty());
		
		medicineDetailsRepository.save(foundMedicine);
		return medConverter.convertToMedicineDetailsDTO(foundMedicine);
	}

	@Override
	public MedicineDetailsDTO getMedicineDetailsById(int medid) {
		MedicineDetails getM = medicineDetailsRepository.findById(medid).orElseThrow(()->
		new ResourceNotFoundException("MedicineDetails", "MedID", medid));
		return medConverter.convertToMedicineDetailsDTO(getM);
//		MedicineDetails foundmed = medicineDetailsRepository.findById(medid).get();
//		return medConverter.convertToMedicineDetailsDTO(foundmed);
	}

	@Override
	public List<MedicineDetailsDTO> getAllMedicineDetails() {
		List<MedicineDetails> allMedicineDetailsList = medicineDetailsRepository.findAll();

		List<MedicineDetailsDTO> allMedicineDetailsDTOs = new ArrayList<>();

		for (MedicineDetails medicineDetails : allMedicineDetailsList) {
			allMedicineDetailsDTOs.add(medConverter.convertToMedicineDetailsDTO(medicineDetails));
		}

		return allMedicineDetailsDTOs;
	}

	@Override
	public String deleteMedicineDetailsById(int medid) {
		Optional<MedicineDetails> medicineDetails = medicineDetailsRepository.findById(medid);

		if (medicineDetails.isPresent()) {
			medicineDetailsRepository.deleteById(medid);
			return "Medicine Details Are Deleted Successfully :)";
		}

		return "Medicine Details are Not Found :(";
	}

	@Override
	public void deleteAllMedicineDetails() {
		medicineDetailsRepository.deleteAll();
		
	}

	@Override
	public List<MedicineDetailsDTO> getMedicineDetailsByName(String medName) {
		List<MedicineDetails> medicineList = medicineDetailsRepository.getMedicineDetailsByName(medName);

		List<MedicineDetailsDTO> allMedicineDetailsDTOs = new ArrayList<>();

		for (MedicineDetails medicineDetails : medicineList) {
			allMedicineDetailsDTOs.add(medConverter.convertToMedicineDetailsDTO(medicineDetails));
		}

		return allMedicineDetailsDTOs;
	}

	
}
