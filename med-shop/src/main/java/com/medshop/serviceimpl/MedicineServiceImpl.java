package com.medshop.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medshop.entity.Medicine;
import com.medshop.exception.ResourceNotFoundException;
import com.medshop.model.MedicineDTO;
import com.medshop.repository.MedicineRepository;
import com.medshop.service.MedicineService;
import com.medshop.util.MedicineConverter;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	private static final Logger l = LoggerFactory.getLogger(Medicine.class);
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	private MedicineConverter medConverter;
	
	@Override
	public String createMedicine(Medicine medicine) {
		String message = null;
		medicineRepository.save(medicine);
		if (medicine != null) {
			message = "Medicine Details are Saved Successfully";
		}
		return message;
	}

	@Override
	public MedicineDTO updateMedicine(int medid, Medicine medicine) {
		Medicine foundMedicine = medicineRepository.findById(medid).orElseThrow(()->
		new ResourceNotFoundException("MedicineDetails", "MedID", medid));


		foundMedicine.setMedname(medicine.getMedname());
		foundMedicine.setComponame(medicine.getComponame());
		foundMedicine.setPrice(medicine.getPrice());
		foundMedicine.setQtyavailable(medicine.getQtyavailable());
		
		 
		l.info("Admin "+medicine.toString()+" added at "+ new Date());
		medicineRepository.save(foundMedicine);
		return medConverter.ConvertToMedicineDTO(foundMedicine);
	}

	@Override
	public MedicineDTO getMedicineById(int medid) {
		Medicine getM = medicineRepository.findById(medid).orElseThrow(()->
		new ResourceNotFoundException("MedicineDetails", "MedID", medid));
		l.info("Getting medicine details with ID "+medid+" at "+new Date());
		return medConverter.ConvertToMedicineDTO(getM);
	}

	@Override
	public List<MedicineDTO> getAllMedicine() {
		List<Medicine> allMedicineList = medicineRepository.findAll();

		List<MedicineDTO> allMedicineDTOs = new ArrayList<>();

		for (Medicine medicine : allMedicineList) {
			allMedicineDTOs.add(medConverter.ConvertToMedicineDTO(medicine));
		}

		return allMedicineDTOs;
	}

	@Override
	public String deleteMedicineById(int medid) {
		Optional<Medicine> medicine = medicineRepository.findById(medid);

		if (medicine.isPresent()) {
			medicineRepository.deleteById(medid);
			return "Medicine Details Are Deleted Successfully :)";
		}
		l.info("Getting medicine details with ID "+medid+" at "+new Date());
		return "Medicine Details are Not Found :(";
	}

	@Override
	public void deleteAllMedicine() {
		medicineRepository.deleteAll();
		
	}

	@Override
	public List<MedicineDTO> getMedicineByName(String medname) {
		List<Medicine> medicineList = medicineRepository.getMedicineByMedname(medname);

		List<MedicineDTO> allMedicineDTOs = new ArrayList<>();

		for (Medicine medicine : medicineList) {
			allMedicineDTOs.add(medConverter.ConvertToMedicineDTO(medicine));
		}

		return allMedicineDTOs;
	}

	@Override
	public List<MedicineDTO> getMedicineByPrice(double price) {
		List<Medicine> medicineList = medicineRepository.getMedicineByPrice(price);

		List<MedicineDTO> allMedicineDTOs = new ArrayList<>();

		for (Medicine medicine : medicineList) {
			allMedicineDTOs.add(medConverter.ConvertToMedicineDTO(medicine));
		}

		return allMedicineDTOs;
	}

}
