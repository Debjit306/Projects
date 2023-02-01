package com.medshop.service;

import com.medshop.entity.Admin;
import com.medshop.model.AdminDTO;

public interface AdminService {

	String createAdmin(Admin admin);
	
	AdminDTO updateAdmin(int id, Admin admin);
	
	AdminDTO getAdminById(int id);
	
	String deleteAdminById(int id);
}
