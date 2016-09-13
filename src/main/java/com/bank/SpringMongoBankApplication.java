package com.bank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.service.CustomerService;

@SpringBootApplication
public class SpringMongoBankApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoBankApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		setupCustomer();
	}

	private void setupCustomer() {
		// delete all Customer records
		  customerService.dropCustomerCollection();  
		   
		     Address address = new Address();
		     address.setNumber("81");
		     address.setStreet("Mongo Street");
		     address.setTown("City");
		     address.setPostcode("CT81 1DB");
		     
		     Account account = new Account();
		     account.setAccountName("Personal Account");
		     List<Account> accounts = new ArrayList<Account>();
		     accounts.add(account);
		      
		     Customer customer = new Customer();
		     customer.setAddress(address);
		     customer.setName("Mr Bank Customer");
//		     customer.setAccounts(accounts);
		           
		     // insert a Customer record into the database
		  customerService.insertCustomer(customer);          
		      
		     address = new Address();
		     address.setNumber("101");
		     address.setStreet("Mongo Road");
		     address.setTown("Town");
		     address.setPostcode("TT10 5DB");
		     
		     account = new Account();
		     account.setAccountName("Business Account");
		     accounts = new ArrayList<Account>();
		     accounts.add(account);
		      
		     customer = new Customer();
		     customer.setAddress(address);
		     customer.setName("Mr Customer");
//		     customer.setAccounts(accounts);  
		 
		     // insert a Customer record into the database
		  customerService.insertCustomer(customer);
	}
}
