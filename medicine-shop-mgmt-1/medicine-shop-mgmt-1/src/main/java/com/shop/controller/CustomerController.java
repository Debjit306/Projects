package com.shop.controller;

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

import com.shop.entity.Customer;
import com.shop.model.CustomerDTO;
import com.shop.service.CustomerService;
import com.shop.util.CustomerConverter;




@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerConverter cusConverter;
	
	@PostMapping("/createCustomer")
	public String createCustomer(@RequestBody CustomerDTO customerDTO) {

		final Customer customer = cusConverter.convertToEntity(customerDTO);
		
		return customerService.createCustomer(customer);
		}
	
	@PutMapping("/updateCustomer/{cusid}")
	public CustomerDTO updateCustomer(@PathVariable("cusid") int cusid, @RequestBody CustomerDTO customerDTO) {

		Customer customer = cusConverter.convertToEntity(customerDTO);
		return customerService.updateCustomer(cusid, customer);
	}
	
	@GetMapping("/getCustomerById/{cusid}")
	public CustomerDTO getCustomerById(@PathVariable("cusid") int cusid) {

		return customerService.getCustomerById(cusid);
	}
	
	@GetMapping("/getAllCustomer")
	public List<CustomerDTO> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping("/deleteCustomerById/{cusid}")
	public String deleteCustomerById(@PathVariable("cusid") int cusid) {
		return customerService.deleteCustomerById(cusid);
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

		return customerService.getCustomerByEmailId(email);
	}
}