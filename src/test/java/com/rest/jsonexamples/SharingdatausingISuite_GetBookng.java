package com.rest.jsonexamples;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SharingdatausingISuite_GetBookng {

	
	@Test
	public void createBooking(ITestContext context){
		
		RestAssured.given().log().all().get("https://restful-booker.herokuapp.com/booking/"+context.getSuite().getAttribute("bookingid")).
		then().log().all().extract().response();
		
	}

}
