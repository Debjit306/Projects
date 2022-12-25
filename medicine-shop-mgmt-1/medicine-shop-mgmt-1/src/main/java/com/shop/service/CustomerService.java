package com.shop.service;

import java.util.List;

import com.shop.entity.Customer;
import com.shop.model.CustomerDTO;


public interface CustomerService {
	
	String createCustomer(Customer customer);

	CustomerDTO updateCustomer(int cusid, Customer customer);

	CustomerDTO getCustomerById(int cusid);

	List<CustomerDTO> getAllCustomer();

	String deleteCustomerById(int cusid);

	void deleteAllCustomer();

	List<CustomerDTO> getCustomerByName(String customerName);

	List<CustomerDTO> getCustomerByEmailId(String cusEmailId);
}
