package com.rest.threads;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ThreadLocalTestModuleParallelasMap_2 {
	
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
		
		ThreadLocalDatastoreasMap.setValue("bookingid", id);
		
		System.out.println("Thread ID is " + Thread.currentThread().getId() + " Create Booking ID is " + 
				ThreadLocalDatastoreasMap.getValue("bookingid"));
		
	}
		
	
	@Test(priority=2)
	public void retrivebookingdetails(){
		
		System.out.println("Thread ID is " + Thread.currentThread().getId() + "vRetrive Booking ID is " + 
				ThreadLocalDatastoreasMap.getValue("bookingid"));
		
		int bookingid = (int) ThreadLocalDatastoreasMap.getValue("bookingid");
		
		RestAssured.given().log().all().get("https://restful-booker.herokuapp.com/booking/"+bookingid).
		then().log().all().extract().response();
		
		
	}
		
	
	
	
}
