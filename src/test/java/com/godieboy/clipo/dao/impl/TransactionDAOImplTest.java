package com.godieboy.clipo.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.godieboy.clipo.dao.TransactionDAO;
import com.godieboy.clipo.model.Transaction;

public class TransactionDAOImplTest {
	
	private TransactionDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new TransactionDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testAdd() {
		Transaction transaction = new Transaction();
		transaction = dao.add(transaction);
		assertNotNull("transaction id not null",transaction.getId());
	}

	@Test
	public void testList() {
		String userId = "1";
		List<Transaction> list = dao.list(userId);
		assertNotNull("List of transaction not null", list);
	}

	@Test
	public void testShow() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSum() {
		//fail("Not yet implemented");
	}

}
