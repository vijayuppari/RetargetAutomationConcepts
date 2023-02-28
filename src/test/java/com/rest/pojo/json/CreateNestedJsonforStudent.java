package com.rest.pojo.json;

import io.restassured.RestAssured;

public class CreateNestedJsonforStudent {
	
	public static void main(String[] args) {
		
		
		studentNestedJson sjson= new studentNestedJson();
		sjson.setId(500);
		sjson.setName("Naresh");
		sjson.setDepartment("ECE");
		
	
		Address address= new Address();
		address.setFlat(405);
		address.setArea("Sai Baba Nagar Colony");
		address.setCity("Hyderabad");
		address.setCountry("INDIA");
		
		sjson.setAddress(address);
		
		String response =RestAssured.given().log().all().body(sjson).when().
		post().then().extract().asString();
		System.out.println(response);
		
		
		
	}

}
