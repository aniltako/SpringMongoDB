package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Customer;
import com.bank.service.CustomerService;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/addCustomer", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer){
		
		return customerService.insertCustomer(customer);
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	@RequestMapping(value="/deleteAll", method = RequestMethod.DELETE)
	public void deleteAllCustomer(){
		customerService.dropCustomerCollection();
	}
	
}
