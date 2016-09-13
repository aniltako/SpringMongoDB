package com.bank.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Customer;

@Repository
public interface CustomerDAO extends MongoRepository<Customer, String>{

	
}
