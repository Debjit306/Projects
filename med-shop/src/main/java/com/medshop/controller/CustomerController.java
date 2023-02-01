package com.medshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medshop.entity.Customer;
import com.medshop.model.CustomerDTO;
import com.medshop.service.CustomerService;
import com.medshop.util.CustomerConverter;





@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerConverter cusConverter;
	
	@PostMapping("/createCustomer")
	public String createCustomer(@RequestBody CustomerDTO customerDTO) {

		final Customer customer = cusConverter.ConvertToEntity(customerDTO);
		
		return customerService.createCustomer(customer);
		}
	
	@PutMapping("/updateCustomer/{id}")
	public CustomerDTO updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDTO customerDTO) {

		Customer customer = cusConverter.ConvertToEntity(customerDTO);
		return customerService.updateCustomer(id, customer);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public CustomerDTO getCustomerById(@PathVariable("id") int id) {

		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/getAllCustomer")
	public List<CustomerDTO> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping("/deleteCustomerById/{id}")
	public String deleteCustomerById(@PathVariable("id") int id) {
		return customerService.deleteCustomerById(id);
	}
	
	@DeleteMapping("/deleteAllCustomer")
	public ResponseEntity<String> deleteAllCustomer() {

		customerService.deleteAllCustomer();

		return new ResponseEntity<>("All Customer have been deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByName/{name}")
	public List<CustomerDTO> getCustomerByName(@PathVariable("name") String customerName) {

		return customerService.getCustomerByName(customerName);
	}
	
	@GetMapping("/getCustomerByEmail/{email}")
	public List<CustomerDTO> getCustomerByEmail(@PathVariable("email") String email) {

		return customerService.getCustomerByEmail(email);
	}
}
