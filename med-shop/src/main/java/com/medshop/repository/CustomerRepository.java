package com.medshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medshop.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer getCustomerByEmailAndName (String email, String name);

	public List<Customer> getCustomerByName(String name);

	public List<Customer> getCustomerByEmail(String Email);
}
