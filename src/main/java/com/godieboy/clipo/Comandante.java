package com.godieboy.clipo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.godieboy.clipo.dao.TransactionDAO;
import com.godieboy.clipo.dao.impl.TransactionDAOImpl;
import com.godieboy.clipo.exceptions.TransactionNotFounException;
import com.godieboy.clipo.model.Transaction;
import com.godieboy.clipo.model.converter.JsonConverter;

public class Comandante {
	
	public static void main(String[] args) throws TransactionNotFounException {
		String errorMessage = "";
		if(args.length > 0) {
		String userIdString = args[0];
		System.out.println("user id === " + userIdString);
		
		TransactionDAO dao = new TransactionDAOImpl();
		Transaction transaction;
		if(args.length > 1){
			String actionString = args[1];
			
		switch (actionString) {
		case "add":
			String json = args[3];
			 transaction = JsonConverter.jsonToEntity(json);
			 transaction.setUserId(userIdString);
			 transaction = dao.add(transaction);
			System.out.println(transaction.toString());
			break;
		case "list":
			List<Transaction> list = dao.list(userIdString);
			System.out.println("[");
			for(Transaction t : list) { 
				System.out.println(t.toString());
			}
			System.out.println("]");
		break;
		
		case "sum":
			Map<String, Double> sum = dao.sum(userIdString);
			System.out.println(sum);
			break;
		default:
			 transaction = dao.show(actionString, userIdString);
			System.out.println(transaction.toString());
			break;
		}

		}else {
			errorMessage = "No action why?";

		}

		}
		else {
			errorMessage = "No User why?";
		}
		System.out.print(errorMessage);

	}

}
