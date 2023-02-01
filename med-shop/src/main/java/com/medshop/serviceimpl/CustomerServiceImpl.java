package com.medshop.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medshop.entity.Customer;
import com.medshop.exception.ResourceNotFoundException;
import com.medshop.model.CustomerDTO;
import com.medshop.repository.CustomerRepository;
import com.medshop.service.CustomerService;
import com.medshop.util.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger l = LoggerFactory.getLogger(Customer.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter cusConverter;
	
	@Override
	public String createCustomer(Customer customer) {
		String message=null;
		customer.setUsername(customer.getUsername());
		customer.setPassword(customer.getPassword());
		customer.setRole(customer.getRole());
		customerRepository.save(customer);
		if(customer!= null) {
			message= "Customer Are Register succesfully";
		}
		
		return message;
	}

	@Override
	public CustomerDTO updateCustomer(int id, Customer customer) {
		Customer foundCustomer = customerRepository.findById(id).get();

		foundCustomer.setName(customer.getName());
		foundCustomer.setContactNo(customer.getContactNo());
		foundCustomer.setEmail(customer.getEmail());
		foundCustomer.setCusAddress(customer.getCusAddress());
		
		l.info("Admin "+customer.toString()+" added at "+ new Date());
		customerRepository.save(foundCustomer);
		return cusConverter.ConvertToCustomerDTO(foundCustomer);
	}

	@Override
	public CustomerDTO getCustomerById(int id) {
		Customer getC = customerRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer", "ID", id));
		l.info("Getting Customer details with ID "+id+" at "+new Date());
		return cusConverter.ConvertToCustomerDTO(getC);
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<Customer> allCustomerList = customerRepository.findAll();

		List<CustomerDTO> allCustomerDTOs = new ArrayList<>();

		for (Customer customer : allCustomerList) {
			allCustomerDTOs.add(cusConverter.ConvertToCustomerDTO(customer));
		}
		
		return allCustomerDTOs;
	}

	@Override
	public String deleteCustomerById(int id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (customer.isPresent()) {
			customerRepository.deleteById(id);
			return "Customer Deleted Successfully :)";
		}
		l.info("Getting customer details with ID "+id+" at "+new Date());
		return "Customer Not Found :(";
	}

	@Override
	public void deleteAllCustomer() {
		customerRepository.deleteAll();
		
	}

	@Override
	public List<CustomerDTO> getCustomerByName(String name) {
		List<Customer> customerList = customerRepository.getCustomerByName(name);
		
		List<CustomerDTO> allCustomerDTOs = new ArrayList<>();

		for (Customer customer : customerList) {
			allCustomerDTOs.add(cusConverter.ConvertToCustomerDTO(customer));
		}
		
		return allCustomerDTOs;
	}

	@Override
	public List<CustomerDTO> getCustomerByEmail(String email) {
		List<Customer> customerList = customerRepository.getCustomerByEmail(email);
		
		List<CustomerDTO> allCustomerDTOs = new ArrayList<>();

		for (Customer customer : customerList) {
			allCustomerDTOs.add(cusConverter.ConvertToCustomerDTO(customer));
		}

		return allCustomerDTOs;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
