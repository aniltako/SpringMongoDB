package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.model.Customer;

@Component
public interface CustomerService {

	Customer insertCustomer(Customer customer);
	void dropCustomerCollection();
	List<Customer> getCustomers();
}
