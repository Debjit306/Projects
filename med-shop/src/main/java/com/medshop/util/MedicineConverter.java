package com.medshop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.medshop.entity.Medicine;
import com.medshop.model.MedicineDTO;


@Component
public class MedicineConverter {
	public Medicine ConvertToEntity(MedicineDTO medicineDTO)
	{
		Medicine medicine = new Medicine();
		if (medicineDTO !=null) 
		{
			BeanUtils.copyProperties(medicineDTO,medicine);
		}
		return medicine;
	}
	public MedicineDTO ConvertToMedicineDTO(Medicine medicine)
	{
		MedicineDTO medicineDTO = new MedicineDTO();
		if (medicine !=null) 
		{
			BeanUtils.copyProperties(medicine,medicineDTO);
		}
		return medicineDTO;
	}
}
