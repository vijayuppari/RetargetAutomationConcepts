package com.rest.pojo.json;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class createJsonArrayfromPojo_Student {
	
	public static void main(String[] args) {
		
		studentpojo student1 = new studentpojo();
		student1.setId(100);
		student1.setName("Vijay");
		student1.setGender("Male");
		student1.setDepartment("IT");
		
		studentpojo student2 = new studentpojo();
		student2.setId(200);
		student2.setName("Nani");
		student2.setGender("Male");
		student2.setDepartment("CSE");
		
		List<studentpojo>slist= new ArrayList<studentpojo>();
		slist.add(student1);
		slist.add(student2);
		
		
		
		String response = RestAssured.given().log().all().body(slist).when().get().then().
				extract().asString();
		System.out.println(response);
		
	}
	

}
