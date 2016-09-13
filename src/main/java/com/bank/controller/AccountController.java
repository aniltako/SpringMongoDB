package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/addAccount", method = RequestMethod.POST)
	public Account addAccount(@RequestBody Account account, @RequestParam String customerId){
		return accountService.addAccount(account, customerId);
	}
	
	@RequestMapping(value="/account", method = RequestMethod.GET)
	public Account getAccountBy(@RequestParam String id){
		
		return accountService.getAccount(id);
	}
	
	@RequestMapping(value="/withdraw", method = RequestMethod.GET)
	public Account withdraw(@RequestParam String id, @RequestParam int amount){
		return accountService.withDraw(id, amount);
	}
}
