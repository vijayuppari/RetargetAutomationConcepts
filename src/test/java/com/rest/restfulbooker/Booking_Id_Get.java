package com.rest.restfulbooker;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Booking_Id_Get {

	// Approach 1:
	@Test
	public void getbookingId() {

		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking/{id}")
				.pathParam("id", 30).when().get().then().log().all().statusCode(200);

	}

	// Approach 2:
	@Test
	public void getbookingId_2() {

		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{basepath}/{bookingid}").pathParam("basepath", "booking").pathParam("bookingid", 30).when()
				.get().then().log().all().statusCode(200);
	}

	// Approach 3:
	@Test
	public void getbookingId_3() {

		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{basepath}/{bookingid}").when()
				.get("https://restful-booker.herokuapp.com/{basepath}/{bookingid}","booking",30).
				then().log().all().statusCode(200);
	}
	
	// Approach 4: Using map
		@Test
		public void getbookingId_Map() {

			Map<String, Object> bookingpath = new HashMap<String, Object>();
			bookingpath.put("basepath", "booking");
			bookingpath.put("bookingid", 30);
			
			
			RestAssured.given().
			log().all().
			baseUri("https://restful-booker.herokuapp.com/")
			.basePath("{basepath}/{bookingid}").
			pathParams(bookingpath).
			when()
			.get().
			then().log().all().
			statusCode(200);
		}
	
}
