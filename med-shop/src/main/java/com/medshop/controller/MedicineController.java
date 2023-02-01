package com.medshop.controller;

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

import com.medshop.entity.Medicine;
import com.medshop.model.MedicineDTO;
import com.medshop.service.MedicineService;
import com.medshop.util.MedicineConverter;



@RestController
@RequestMapping("/api")
public class MedicineController {

	@Autowired
	private MedicineService medService;
	
	@Autowired
	private MedicineConverter medConverter;
	
	@PostMapping("/createMedicine")
	public String createCustomer(@RequestBody MedicineDTO medicineDTO) {

		final Medicine medicine = medConverter.ConvertToEntity(medicineDTO);
		
		return medService.createMedicine(medicine);
		}
	
	@PutMapping("/updateMedicine/{medid}")
	public MedicineDTO updateMedicine(@PathVariable("medid") int medid, @RequestBody MedicineDTO medicineDTO) {

		Medicine medicine = medConverter.ConvertToEntity(medicineDTO);
		return medService.updateMedicine(medid, medicine);
	}
	
	@GetMapping("/getMedicineById/{medid}")
	public MedicineDTO getMedicineById(@PathVariable("medid") int medid) {

		return medService.getMedicineById(medid);
	}
	
	@GetMapping("/getAllMedicine")
	public List<MedicineDTO> getAllMedicine() {
		return medService.getAllMedicine();
	}
	
	@DeleteMapping("/deleteMedicineById/{medid}")
	public String deleteMedicineById(@PathVariable("medid") int medid) {
		return medService.deleteMedicineById(medid);
	}
	
	@DeleteMapping("/deleteAllMedicine")
	public ResponseEntity<String> deleteAllMedicine() {

		medService.deleteAllMedicine();

		return new ResponseEntity<>("All MedicineDetails have been deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getMedicineByName/{name}")
	public List<MedicineDTO> getMedicineByName(@PathVariable("name") String medname) {

		return medService.getMedicineByName(medname);
	}
}
