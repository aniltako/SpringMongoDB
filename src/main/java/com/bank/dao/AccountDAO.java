package com.bank.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.model.Account;

public interface AccountDAO extends MongoRepository<Account, String>{
	
	Account findById(String id);
}
