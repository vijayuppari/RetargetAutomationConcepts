package com.rest.jsonexamples;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class createJsonusingMap {
	
	@Test
	public void exmaplejson() {
		
		Map<String, Object> empmap = new HashMap<>();
	
		empmap.put("firstname", "vijay");
		empmap.put("age", 28);
		empmap.put("salary", 30000);
		empmap.put("department", "IT");
		empmap.put("married", "false");
		
		
		RestAssured.given().
		log().all().contentType(ContentType.JSON).
		body(empmap).
		get();
		
		
	}
	
	

}
