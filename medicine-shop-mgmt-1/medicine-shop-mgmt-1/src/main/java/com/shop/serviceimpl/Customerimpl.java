package com.shop.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.Exception.ResourceNotFoundException;
import com.shop.entity.Customer;
import com.shop.entity.ShopDetails;

import com.shop.model.CustomerDTO;
import com.shop.repository.CustomerRepository;
import com.shop.service.CustomerService;
import com.shop.util.CustomerConverter;

@Service
public class Customerimpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter cusconverter;
	
	
	@Override
	public String createCustomer(Customer customer) {
		String message = null;
		customerRepository.save(customer);
		if (customer != null) {
			message = "Customer Saved Successfully";
		}
		return message;
	}

	@Override
	public CustomerDTO updateCustomer(int cusid, Customer customer) {
		Customer foundCustomer = customerRepository.findById(cusid).get();

		foundCustomer.setCustomerName(customer.getCustomerName());
		foundCustomer.setContactNo(customer.getContactNo());
		foundCustomer.setCusEmail(customer.getCusEmail());
		foundCustomer.setCusAddress(customer.getCusAddress());

		customerRepository.save(foundCustomer);
		return cusconverter.convertToCustomerDTO(foundCustomer);
		
	}

	@Override
	public CustomerDTO getCustomerById(int cusid) {
		Customer getC = customerRepository.findById(cusid).orElseThrow(()->
		new ResourceNotFoundException("Customer", "ID", cusid));
		return cusconverter.convertToCustomerDTO(getC);
//		Customer foundCustomer = customerRepository.findById(cusid).get();
//		return cusconverter.convertToCustomerDTO(foundCustomer);
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<Customer> allCustomerList = customerRepository.findAll();

		List<CustomerDTO> allCustomerDTOs = new ArrayList<>();

		for (Customer customer : allCustomerList) {
			allCustomerDTOs.add(cusconverter.convertToCustomerDTO(customer));
		}

		return allCustomerDTOs;
	}

	@Override
	public String deleteCustomerById(int cusid) {
		Optional<Customer> customer = customerRepository.findById(cusid);

		if (customer.isPresent()) {
			customerRepository.deleteById(cusid);
			return "Customer Deleted Successfully :)";
		}

		return "Customer Not Found :(";
	}

	@Override
	public void deleteAllCustomer() {
		customerRepository.deleteAll();
		
	}

	@Override
	public List<CustomerDTO> getCustomerByName(String customerName) {
		List<Customer> customerList = customerRepository.getCustomerByName(customerName);

		List<CustomerDTO> allCustomerDTOs = new ArrayList<>();

		for (Customer customer : customerList) {
			allCustomerDTOs.add(cusconverter.convertToCustomerDTO(customer));
		}

		return allCustomerDTOs;
		
	}

	@Override
	public List<CustomerDTO> getCustomerByEmailId(String cusEmailId) {
		List<Customer> customerList = customerRepository.getCustomerByEmailId(cusEmailId);

		List<CustomerDTO> allCustomerDTOs = new ArrayList<>();

		for (Customer customer : customerList) {
			allCustomerDTOs.add(cusconverter.convertToCustomerDTO(customer));
		}

		return allCustomerDTOs;
	}


}
