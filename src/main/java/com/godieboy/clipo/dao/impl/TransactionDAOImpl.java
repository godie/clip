package com.godieboy.clipo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.godieboy.clipo.dao.TransactionDAO;
import com.godieboy.clipo.exceptions.TransactionNotFounException;
import com.godieboy.clipo.model.Transaction;
import com.godieboy.clipo.util.EntityManagerFactoryUtil;

public class TransactionDAOImpl implements TransactionDAO {

	public Transaction add(Transaction transaction) {
		EntityManager em = EntityManagerFactoryUtil.getEntityManager();
		em.getTransaction().begin();
		if(transaction.getId() == null) {
			String id = UUID.randomUUID().toString();
			transaction.setId(id);
		}
		em.persist(transaction);
		em.getTransaction().commit();

		return transaction;
	}

	public List<Transaction> list(String userId) {
		String queryJQL = "Select t from Transaction t where t.userId = "+ userId;
		EntityManager em = EntityManagerFactoryUtil.getEntityManager();
		Query query = em.createQuery(queryJQL, Transaction.class);
		List<Transaction> transactionList = query.getResultList();
		return transactionList;
	}


	public 	Transaction show(String transactionId, String userId) throws TransactionNotFounException {
		try {
		String queryJQL = "Select t from Transaction t where t.id= :transactionId AND t.userId = :userId" ;
		EntityManager em = EntityManagerFactoryUtil.getEntityManager();
		
		Query query = em.createQuery(queryJQL, Transaction.class);
		query.setParameter("userId", userId);
		query.setParameter("transactionId", transactionId);
		Transaction t = (Transaction) query.getSingleResult();
		return t;
		}catch (Exception e) {
			throw new TransactionNotFounException("TRANSACTION NOT FOUND");
		}
		
	}


	public Map<String, Double> sum(String userId) {
		EntityManager em = EntityManagerFactoryUtil.getEntityManager();
		Query query = em.createQuery("SELECT sum(t.amount) from Transaction t where t.userId="+userId);
		List results = query.getResultList();
		double sum = (double) results.get(0);
		Map<String, Double> result = new HashMap<>();
		result.put(userId, sum);
		return result;
	}

}
