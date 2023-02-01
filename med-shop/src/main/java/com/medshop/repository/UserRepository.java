package com.medshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medshop.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsernameAndPassword(String username, String password);
}
