package com.godieboy.clipo.model.converter;

import java.sql.Timestamp;

import org.json.JSONObject;

import com.godieboy.clipo.model.Transaction;

public class JsonConverter {
	
	//{ “amount”: 1.23, “description”: “Joes Tacos”, “date”:”2018-12-30”, “user_id”: 345 }

	public static Transaction jsonToEntity(String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		double amount = (double) json.get("amount");
		String description = json.getString("description");
		Timestamp date = (Timestamp) json.get("date");
		Transaction t = new Transaction();
		t.setAmount(amount);
		t.setDescription(description);
		t.setDate(date);
		return t;
	}

}
