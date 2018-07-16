package com.godieboy.clipo.model.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

import com.godieboy.clipo.model.Transaction;

public class JsonConverter {
	
	//{ “amount”: 1.23, “description”: “Joes Tacos”, “date”:”2018-12-30”, “user_id”: 345 }

	public static Transaction jsonToEntity(String jsonString) throws ParseException {
        jsonString = jsonString.replaceAll("“", "");
        jsonString = jsonString.replaceAll("”", "");
		/*JsonParser jsonParser = new JsonParser();		
		JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
		objectFromString.get("amount").getAsDouble();
        System.out.println(objectFromString.keySet());
*/
		System.out.println(jsonString);
		JSONObject json = new JSONObject(jsonString);
		//ymd
		 //System.out.println(objectFromString);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		double amount = (Double) json.get("amount");
		String description = json.getString("description");
		String date = json.getString("date");
		Transaction t = new Transaction();
		t.setAmount(amount);
		t.setDescription(description);
		
		t.setDate(new Timestamp(sdf.parse(date).getTime()));
		return t;
	}

}
