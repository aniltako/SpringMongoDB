package com.bank.service;

import java.util.List;

import com.bank.model.Account;

public interface AccountService {

	Account addAccount(Account account, String customerId);
	Account getAccount(String id);
	
	Account withDraw(String id, int amount);
	
}
