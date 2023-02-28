package com.rest.restfulbooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Booking_extractbodyasString {

	// Approach 1:
	@Test
	public void getbookingId() {

		String ResponseasString = RestAssured.given().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking/{id}")
	    .pathParam("id", 30).
		when().get().then().statusCode(200).
		extract().
		body().asString();
		System.out.println(ResponseasString);

	}
	// Approach 2:
		@Test
		public void getbookingIdasprettystring() {

			String ResponseasString = RestAssured.given().
			baseUri("https://restful-booker.herokuapp.com/").
			basePath("booking/{id}")
		    .pathParam("id", 30).
			when().get().then().statusCode(200).
			extract().response().
			asString();
			System.out.println(ResponseasString);

		}
	
}
