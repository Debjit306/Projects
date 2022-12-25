package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	@Query("from Customer where lower(customerName) like :n%")
	List<Customer> getCustomerByName(@Param("n") String customerName);

	@Query("from Customer where email=:e ")
	List<Customer> getCustomerByEmailId(@Param("e") String cusEmailId);
	
}
