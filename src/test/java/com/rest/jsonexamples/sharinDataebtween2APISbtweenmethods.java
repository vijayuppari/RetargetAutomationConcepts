package com.rest.jsonexamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class sharinDataebtween2APISbtweenmethods {
	
	String payload=("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,"
			+ "\"bookingdates\":{\"checkin\":\"2018-01-01\","
			+ "\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}");
	
	private int bookingid;
	
	@Test(priority=1)
	public void createbookingdetails(){
		
		bookingid = RestAssured.given().log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		body(payload).
		contentType(ContentType.JSON).
		post().
		then().log().all().
		statusCode(200).extract().jsonPath().getInt("bookingid");
		
		
		RestAssured.given().log().all().get("https://restful-booker.herokuapp.com/booking/"+bookingid).
		then().log().all().extract().response();
		
	}
		
	
	@Test(priority=2)
	public void retrivebookingdetails(){
		
		RestAssured.given().log().all().get("https://restful-booker.herokuapp.com/booking/"+bookingid).
		then().log().all().extract().response();
		
		
	}
		
	
	
	
}
