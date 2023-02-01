package com.medshop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.medshop.entity.Admin;
import com.medshop.model.AdminDTO;


@Component
public class AdminConverter {
	public Admin ConvertToEntity(AdminDTO adminDTO)
	{
		Admin admin = new Admin();
		if (adminDTO !=null) 
		{
			BeanUtils.copyProperties(adminDTO,admin);
		}
		return admin;
	}
	public AdminDTO ConvertToAdminDTO(Admin admin)
	{
		AdminDTO adminDTO = new AdminDTO();
		if (admin !=null) 
		{
			BeanUtils.copyProperties(admin,adminDTO);
		}
		return adminDTO;
	}
}
