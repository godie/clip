package com.godieboy.clipo.dao;

import java.util.List;
import java.util.Map;

import com.godieboy.clipo.exceptions.TransactionNotFounException;
import com.godieboy.clipo.model.Transaction;



public interface TransactionDAO {
	
	Transaction add(Transaction transaction);
	List<Transaction> list(String userId);
	Transaction show(String transactionId, String userId) throws TransactionNotFounException;
	Map<String, Double> sum(String userId);
}
