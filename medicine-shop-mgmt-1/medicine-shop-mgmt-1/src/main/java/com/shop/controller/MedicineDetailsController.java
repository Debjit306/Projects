package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.MedicineDetails;
import com.shop.model.MedicineDetailsDTO;
import com.shop.service.MedicineDetailsService;
import com.shop.util.MedicineDetailsConverter;


@RestController
@RequestMapping("/api")
public class MedicineDetailsController {
	@Autowired
	private MedicineDetailsService medService;
	
	@Autowired
	private MedicineDetailsConverter medConverter;
	
	@PostMapping("/createMedicineDetails")
	public String createCustomer(@RequestBody MedicineDetailsDTO medicineDetailsDTO) {

		final MedicineDetails medicineDetails = medConverter.convertToEntity(medicineDetailsDTO);
		
		return medService.createMedicineDetails(medicineDetails);
		}
	
	@PutMapping("/updateMedicineDetails/{medid}")
	public MedicineDetailsDTO updateMedicineDetails(@PathVariable("medid") int medid, @RequestBody MedicineDetailsDTO medicineDetailsDTO) {

		MedicineDetails medicineDetails = medConverter.convertToEntity(medicineDetailsDTO);
		return medService.updateMedicineDetails(medid, medicineDetails);
	}
	
	@GetMapping("/getMedicineDetailsById/{medid}")
	public MedicineDetailsDTO getMedicineDetailsById(@PathVariable("medid") int medid) {

		return medService.getMedicineDetailsById(medid);
	}
	
	@GetMapping("/getAllMedicineDetails")
	public List<MedicineDetailsDTO> getAllMedicineDetails() {
		return medService.getAllMedicineDetails();
	}
	
	@DeleteMapping("/deleteMedicineDetailsById/{medid}")
	public String deleteMedicineDetailsById(@PathVariable("medid") int medid) {
		return medService.deleteMedicineDetailsById(medid);
	}
	
	@DeleteMapping("/deleteAllMedicineDetails")
	public ResponseEntity<String> deleteAllMedicineDetails() {

		medService.deleteAllMedicineDetails();

		return new ResponseEntity<>("All MedicineDetails have been deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getMedicineDetailsByName/{name}")
	public List<MedicineDetailsDTO> getMedicineDetailsByName(@PathVariable("name") String medName) {

		return medService.getMedicineDetailsByName(medName);
	}
}
