package com.bank.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer extends BaseEntity{

	private String name;
//	private List<Account> accounts;
	private Address address;
	private List<String> accountId;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getAccountId() {
		return accountId;
	}
	public void setAccountId(List<String> accountId) {
		this.accountId = accountId;
	}
	
	
	
	
	
}
