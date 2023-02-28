package com.rest.jsonexamples;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SharingdatausingItextContext_createBooking {
	
	String payload=("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,"
			+ "\"bookingdates\":{\"checkin\":\"2018-01-01\","
			+ "\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}");
	
	@Test
	public void createBooking(ITestContext context){
		
		int bookingid = RestAssured.given().log().all().
				baseUri("https://restful-booker.herokuapp.com/").
				basePath("booking").
				body(payload).
				contentType(ContentType.JSON).
				post().
				then().log().all().
				statusCode(200).extract().jsonPath().getInt("bookingid");
		
		context.setAttribute("bookingid", bookingid);
		
	}

}
