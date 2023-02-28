package com.rest.restfulbooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Booking_Post {
	
	String payload=("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,"
			+ "\"bookingdates\":{\"checkin\":\"2018-01-01\","
			+ "\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}");
			
		
	@Test
	public void bookingstepbystep() {
		
		
		RequestSpecification requestSpecification = RestAssured.given().log().all();
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking");
		
		requestSpecification.body(payload);
		
		requestSpecification.contentType(ContentType.JSON);
		
		Response validateresponse = requestSpecification.post();
		
		ValidatableResponse validatableResponse = validateresponse.then();
		
		validatableResponse.statusCode(200);
		
	}
	
	@Test(enabled=true)
	public void bookingadvanced() {
		
		// log().all() use to print request and response in the console
		// If we use log().all() in the given place it will print request and if we use in then() 
		//place it will print response
		
		RestAssured.given().log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		body(payload).
		contentType(ContentType.JSON).
		post().
		then().log().all().
		statusCode(200);	}

}
