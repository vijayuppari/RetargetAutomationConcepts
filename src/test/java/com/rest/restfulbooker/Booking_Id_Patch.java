package com.rest.restfulbooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Booking_Id_Patch {
	
String payload="{\"firstname\":\"Vijay\",\"lastname\":\"Uppari\"}";
	
	
	@Test
	public void Bookingpatch(){
		
		RestAssured.given().log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking/2").
		contentType(ContentType.JSON).
		header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
		body(payload).
		when().
		patch().
		then().log().all().
		statusCode(200);	
		
	}

}
