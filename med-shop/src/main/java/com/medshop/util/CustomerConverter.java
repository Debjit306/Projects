package com.medshop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.medshop.entity.Customer;
import com.medshop.model.CustomerDTO;



@Component
public class CustomerConverter {
	public Customer ConvertToEntity(CustomerDTO customerDTO)
	{
		Customer customer = new Customer();
		if (customerDTO !=null) 
		{
			BeanUtils.copyProperties(customerDTO,customer);
		}
		return customer;
	}
	public CustomerDTO ConvertToCustomerDTO(Customer customer)
	{
		CustomerDTO customerDTO = new CustomerDTO();
		if (customer !=null) 
		{
			BeanUtils.copyProperties(customer,customerDTO);
		}
		return customerDTO;
	}
}
