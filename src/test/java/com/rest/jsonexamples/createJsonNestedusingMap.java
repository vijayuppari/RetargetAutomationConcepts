package com.rest.jsonexamples;


import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class createJsonNestedusingMap {
	
	@Test
	public void exmaplejson() {
		
		Map<String, Object> empmap = new LinkedHashMap<>();
	
		empmap.put("firstname", "vijay");
		empmap.put("age", 28);
		empmap.put("salary", 30000);
		empmap.put("department", "IT");
		empmap.put("married", "false");
		
		Map<String, Object> addressmap = new LinkedHashMap<>();
		
		addressmap.put("H.NO", "9-44/3");
		addressmap.put("Street", "Gajulapet");
		addressmap.put("Mandal", "Bhiknoor");
		addressmap.put("Dist", "Kamareddy");
		
		empmap.put("address", addressmap);
		
		RestAssured.given().
		log().all().contentType(ContentType.JSON).
		body(empmap).
		get();
		
		
	}
	
	

}
