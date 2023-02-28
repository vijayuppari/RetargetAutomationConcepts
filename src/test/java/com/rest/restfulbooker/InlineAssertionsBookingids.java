package com.rest.restfulbooker;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class InlineAssertionsBookingids {
	
	public static void main(String[] args) {
		
		RestAssured.given().log()
		.all().baseUri("https://restful-booker.herokuapp.com/booking").
		contentType(ContentType.JSON).
		when().get().then().log().all().
		body("bookingid", Matchers.hasItems(9,10));
		
		
		
		
		
		
	}

}
