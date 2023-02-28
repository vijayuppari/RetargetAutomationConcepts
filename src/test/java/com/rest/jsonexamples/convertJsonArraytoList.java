package com.rest.jsonexamples;


import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class convertJsonArraytoList {
	
	public static void main(String[] args) {
		
		List asjsonstring = RestAssured.get("https://run.mocky.io/v3/520fa19e-2a54-4b9f-a86c-2c5fe068793e").
		as(List.class);
		
		Map<String,Object>  jsonmap= (Map<String, Object>) asjsonstring.get(0);
		System.out.println(jsonmap.get("email"));
		
		
		
	}

}
