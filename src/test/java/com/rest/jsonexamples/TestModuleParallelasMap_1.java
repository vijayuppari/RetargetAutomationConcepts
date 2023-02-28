package com.rest.jsonexamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestModuleParallelasMap_1 {
	
	String payload=("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,"
			+ "\"bookingdates\":{\"checkin\":\"2018-01-01\","
			+ "\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}");
	
	
	@Test(priority=1)
	public void createbookingdetails(){
		
		
		int id = RestAssured.given().log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		body(payload).
		contentType(ContentType.JSON).
		post().
		then().log().all().
		statusCode(200).extract().jsonPath().getInt("bookingid");
		
		DatastoreasMap.setValue("bookingid", id);
		
		System.out.println("Thread ID is" + Thread.currentThread().getId() + "Create Booking ID is " + 
		DatastoreasMap.getValue("bookingid"));
		
	}
		
	
	@Test(priority=2)
	public void retrivebookingdetails(){
		
		System.out.println("Thread ID is" + Thread.currentThread().getId() + "Retrive Booking ID is " + 
				DatastoreasMap.getValue("bookingid"));
		
		int bookingid = (int) DatastoreasMap.getValue("bookingid");
		
		RestAssured.given().log().all().get("https://restful-booker.herokuapp.com/booking/"+bookingid).
		then().log().all().extract().response();
		
		
	}
		
	
	
	
}
