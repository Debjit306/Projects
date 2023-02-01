package com.medshop.service;

import java.util.List;

import com.medshop.entity.Customer;
import com.medshop.model.CustomerDTO;



public interface CustomerService {
String createCustomer(Customer customer);
	
	CustomerDTO updateCustomer(int id, Customer customer);

	CustomerDTO getCustomerById(int id);

	List<CustomerDTO> getAllCustomer();

	String deleteCustomerById(int id);

	void deleteAllCustomer();

	List<CustomerDTO> getCustomerByName(String name);

	List<CustomerDTO> getCustomerByEmail(String email);

//	Integer isCustomerPresent(Customer customer);

	Customer saveCustomer(Customer customer);
}
