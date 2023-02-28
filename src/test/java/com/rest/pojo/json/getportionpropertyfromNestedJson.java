package com.rest.pojo.json;

import io.restassured.RestAssured;

public class getportionpropertyfromNestedJson {
	
	public static void main(String[] args) {
		
		Address jsonobject = RestAssured.get("https://run.mocky.io/v3/4daed635-9da5-4ed3-b1eb-931455f245a5").
		jsonPath().getObject("address", Address.class);
		
		System.out.println(jsonobject.getCountry());
		System.out.println(jsonobject.getCity());
		
	}

}
