package com.bank.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document
public class Account {

	@Id
	private String id;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdDate;
	
	private String accountName;
	private int totalBalance;
	private List<Transaction> transactions;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}

	public int getTotalBalance() {
		return totalBalance;
	}

	public void setTotolBalance(int totolBalance) {
		this.totalBalance = totolBalance;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
	
	
}
