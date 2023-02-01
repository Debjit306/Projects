package com.medshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medshop.entity.Admin;



public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public List<Admin> findByAdminNameAndEmail (String adminName, String email);
}
