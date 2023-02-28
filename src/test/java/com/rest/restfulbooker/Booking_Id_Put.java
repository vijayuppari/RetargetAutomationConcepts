package com.rest.restfulbooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Booking_Id_Put {
	
	String payload="{\"firstname\":\"Mary\",\"lastname\":\"Ericsson\",\"totalprice\":7000,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2020-11-23\",\"checkout\":\"2021-12-01\"},\"additionalneeds\":\"Breakfast\"}";
	
	
	@Test
	public void Bookingput(){
		
		RestAssured.given().log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking/2").
		contentType(ContentType.JSON).
		header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
		body(payload).
		when().
		put().
		then().log().all().
		statusCode(200);	
		
	}

}
