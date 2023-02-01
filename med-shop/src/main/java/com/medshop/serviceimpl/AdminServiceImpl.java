package com.medshop.serviceimpl;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medshop.entity.Admin;
import com.medshop.exception.ResourceNotFoundException;
import com.medshop.model.AdminDTO;
import com.medshop.repository.AdminRepository;
import com.medshop.service.AdminService;
import com.medshop.util.AdminConverter;

@Service
public class AdminServiceImpl implements AdminService{
	
	private static final Logger l = LoggerFactory.getLogger(Admin.class);
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminConverter admConverter;
	
	@Override
	public String createAdmin(Admin admin) {
		String message=null;
		admin.setUsername(admin.getUsername());
		admin.setPassword(admin.getPassword());
		admin.setRole(admin.getRole());
		adminRepository.save(admin);
		if(admin!= null) {
			message= "Admin Are Register succesfully";
		}
		
		return message;
	}

	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin foundAdmin = adminRepository.findById(id).get();

		foundAdmin.setAdminName(admin.getAdminName());
		foundAdmin.setEmail(admin.getEmail());
		l.info("Admin "+admin.toString()+" added at "+ new Date());
		adminRepository.save(foundAdmin);
		return admConverter.ConvertToAdminDTO(foundAdmin);
	}

	@Override
	public AdminDTO getAdminById(int id) {
		Admin getA = adminRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Admin", "ID", id));
		l.info("Getting admin details with ID "+id+" at "+new Date());
		return admConverter.ConvertToAdminDTO(getA);
	}

	@Override
	public String deleteAdminById(int id) {
		Optional<Admin> admin = adminRepository.findById(id);

		if (admin.isPresent()) {
			adminRepository.deleteById(id);
			return "Admin Deleted Successfully :)";
		}
		l.info("Getting admin details with ID "+id+" at "+new Date());
		return "Admin Not Found :(";
	}

}
