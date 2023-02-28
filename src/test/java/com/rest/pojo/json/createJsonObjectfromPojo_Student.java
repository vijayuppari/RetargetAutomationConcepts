package com.rest.pojo.json;

import io.restassured.RestAssured;

public class createJsonObjectfromPojo_Student {
	
	public static void main(String[] args) {
		
		studentpojo spojo = new studentpojo();
		spojo.setId(100);
		spojo.setName("Vijay");
		spojo.setGender("Male");
		spojo.setDepartment("IT");
		
		
		String response = RestAssured.given().log().all().body(spojo).when().get().then().
				extract().asString();
		System.out.println(response);
		
	}
	

}
