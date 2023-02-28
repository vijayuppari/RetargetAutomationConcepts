package com.rest.pojo.json;

import io.restassured.RestAssured;

public class convertSimpleJsonArrayresponsetoArray {
	
	public static void main(String[] args) {
		
		
		Address[] addressarr = RestAssured.get("https://run.mocky.io/v3/d55286cc-5293-478f-a506-96e6f2b8b1d3").
		as(Address[].class);
		
		System.out.println(addressarr[0].getArea());
		System.out.println(addressarr[1].getArea());
		
	}

}
