package com.rest.jsonexamples;


import java.util.Map;

import io.restassured.RestAssured;

public class convertJsonObjecttoMap {
	
	public static void main(String[] args) {
		
		Map asjsonstring = RestAssured.get("https://run.mocky.io/v3/1811e926-ed61-413e-85de-dcf84a39f432").
		as(Map.class);
		
		Object firstname = asjsonstring.get("firstname");
		System.out.println(firstname);
		
		// Print all
		System.out.println("All keys************");
		asjsonstring.keySet().forEach(k->System.out.println(k));
		
		System.out.println("All key and values************");
		asjsonstring.forEach((k,v)->System.out.println("Key "  + k +" and " + " value is " + v));
		
		//nested values
		System.out.println("Getting nested values************");
		Map<String,String> nestedmap = (Map<String, String>) asjsonstring.get("bookingdates");
		System.out.println(nestedmap.get("checkout"));
		System.out.println(nestedmap.get("checkin"));
		
	}

}
