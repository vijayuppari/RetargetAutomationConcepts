package com.rest.pojo.json;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.restassured.RestAssured;

public class CreateNestedJsonforStudentmultipleaddress {
	
	public static void main(String[] args) {
		
		
		studentwithmultipleaddress sjson= new studentwithmultipleaddress();
		sjson.setId(500);
		sjson.setName("Naresh");
		sjson.setDepartment("ECE");
		
	
		Address address= new Address();
		address.setFlat(405);
		address.setArea("Sai Baba Nagar Colony");
		address.setCity("Hyderabad");
		address.setCountry("INDIA");
		
		Address address2= new Address();
		address2.setFlat(205);
		address2.setArea("Gajulapet");
		address2.setCity("Kamareddy");
		address2.setCountry("INDIA");
		
		LinkedList<Address> ls=new LinkedList<Address>();
		ls.add(address);
		ls.add(address2);
		
		sjson.setAddress(ls);
		
		String response =RestAssured.given().log().all().body(sjson).when().
		post().then().extract().asString();
		System.out.println(response);
		
		
		
	}

}
