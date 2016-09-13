package com.bank.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.dao.CustomerDAO;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.mongodb.WriteResult;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	MongoOperations mongoOperation;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Account addAccount(Account account, String customerId) {
		
		Account acc = new Account();
		if(customerDAO.exists(customerId)){
			
			
			acc.setCreatedDate(new Date());
			acc = accountDAO.save(account);
			
			if(acc != null){
				
				Query query = new Query();
				query.addCriteria(Criteria.where("id").is(customerId));
				mongoOperation.updateMulti(query, new Update().push("accountId", acc.getId()), Customer.class);
			}
			
		}
		return acc;
		
	}


	@Override
	public Account getAccount(String id) {
		return accountDAO.findById(id);
	}

	@Override
	public Account withDraw(String id, int amount) {
		
		Account acc1 = accountDAO.findById(id);
		
		if(acc1.getTotalBalance() > amount){
			
			updateTotalBalance(acc1, id, amount);
			addTrasaction(id, amount);

		}
		
		return accountDAO.findById(id);
		
	}

	private void addTrasaction(String id, int amount) {
		
		System.out.println("Adding transaction");

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		
		Update update  = new  Update();
		update.push("transactions.withDrawAmount", amount);
		
		
		mongoOperation.upsert(query, update, Account.class);
		
		
		
	}

	private void updateTotalBalance(Account acc1, String id, int amount) {
//		acc1.setTotalBalance(500);
//		mongoOperation.save(acc1);
		
		System.out.println("Getting withdraw amount " +amount+ " from " + id + ".");
		System.out.println("Remaining amount is " + (acc1.getTotalBalance() - amount));
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		
		Update update = new Update();
		update.set("totalBalance", (acc1.getTotalBalance() - amount));
//		update.push("transactions.withDrawAmount", amount);
		
//		WriteResult wr = mongoTemplate.updateFirst(query, update, Account.class);
		
		
		mongoOperation.updateFirst(query, update, Account.class);
		
//		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("accountId").is(id));
//		
////		Update update = new Update();
////		update.update("totalBalance", 500);
////		update.push("transactions.withDrawAmount", amount);
//		
//		mongoOperation.updateFirst(query,, Account.class);
		
	}

}
