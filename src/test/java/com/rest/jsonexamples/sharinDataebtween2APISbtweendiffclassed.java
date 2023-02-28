package com.rest.jsonexamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class sharinDataebtween2APISbtweendiffclassed {
	
	String payload=("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,"
			+ "\"bookingdates\":{\"checkin\":\"2018-01-01\","
			+ "\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}");
	
	
	@Test(priority=1)
	public void createbookingdetails(){
		
		Datastoreclass.BOOKING_ID = RestAssured.given().log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		body(payload).
		contentType(ContentType.JSON).
		post().
		then().log().all().
		statusCode(200).extract().jsonPath().getInt("bookingid");
		
	}
		
	
	@Test(priority=2)
	public void retrivebookingdetails(){
		
		RestAssured.given().log().all().get("https://restful-booker.herokuapp.com/booking/"+Datastoreclass.BOOKING_ID).
		then().log().all().extract().response();
		
		
	}
		
	
	
	
}
