package com.bank.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Transaction {
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date transactionDate;
	private int withDrawAmount;
	
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getWithDrawAmount() {
		return withDrawAmount;
	}
	public void setWithDrawAmount(int withDrawAmount) {
		this.withDrawAmount = withDrawAmount;
	}
	
	

}
