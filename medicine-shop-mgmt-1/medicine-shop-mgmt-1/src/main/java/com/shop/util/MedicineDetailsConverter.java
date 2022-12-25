package com.shop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.shop.entity.MedicineDetails;
import com.shop.model.MedicineDetailsDTO;

@Component
public class MedicineDetailsConverter {
	// convert MedicineDetailsDTO to Entity(MedicineDetails)
			public MedicineDetails convertToEntity(MedicineDetailsDTO medicineDetailsDTO) {

				MedicineDetails medicineDetails = new MedicineDetails();
				if (medicineDetailsDTO != null) {
					BeanUtils.copyProperties(medicineDetailsDTO, medicineDetails);
				}

				return medicineDetails;
			}

			// convert Entity(MedicineDetails) to MedicineDetailsDTO
			public MedicineDetailsDTO convertToMedicineDetailsDTO(MedicineDetails medicineDetails) {

				MedicineDetailsDTO medicineDetailsDTO = new MedicineDetailsDTO();
				if (medicineDetails != null) {
					BeanUtils.copyProperties(medicineDetails, medicineDetailsDTO);
				}

				return medicineDetailsDTO;
			}
}
