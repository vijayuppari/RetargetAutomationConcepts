package com.rest.restfulbooker;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class withoutInlineAssertions {
	
	public static void main(String[] args) {
		
		String asString = RestAssured.given().log()
		.all().baseUri("https://restful-booker.herokuapp.com/auth").
		body("{\"username\":\"admin\",\"password\":\"password123\"}").
		contentType(ContentType.JSON).
		when().post().then().log().all().
		extract().asString();
		
		JsonPath jsonPath = new JsonPath(asString);
		System.out.println("Response token as " + jsonPath.get("token") );
		Assert.assertNotNull(jsonPath.get("token"));
		
		
		
	}

}
