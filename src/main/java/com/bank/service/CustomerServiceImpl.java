package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer insertCustomer(Customer customer) {
		return customerDAO.save(customer);
	}

	@Override
	public void dropCustomerCollection() {
		customerDAO.deleteAll();
	}

	@Override
	public List<Customer> getCustomers() {
		return customerDAO.findAll();
	}

}
