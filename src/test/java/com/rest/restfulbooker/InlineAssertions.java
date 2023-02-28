package com.rest.restfulbooker;

import java.util.Base64;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class InlineAssertions {
	
	@Test(enabled=false)
	public static void verifytoken(){
		RestAssured.given().log()
		.all().baseUri("https://restful-booker.herokuapp.com/auth").
		body("{\"username\":\"admin\",\"password\":\"password123\"}").
		contentType(ContentType.JSON).
		when().post().then().log().all().
		body("token", Matchers.notNullValue()).
		body("token.length()",Matchers.is(15));
		
	}
	
	@Test(enabled=true)
	public static void gettokenusingresponse(){
		String response1 = RestAssured.given().log()
		.all().baseUri("https://restful-booker.herokuapp.com/auth").
		body("{\"username\":\"admin\",\"password\":\"password123\"}").
		contentType(ContentType.JSON).
		when().post().then().extract().response().asString();
		JsonPath jsonPath = new JsonPath(response1);
		System.out.println(jsonPath.getString("token"));
		
	}
	
	// Get the access token from this method
	public static String getToken(String str1, String str2){
	        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
	    }
	
	public static void main(String[] args) {
		System.out.println(getToken("admin", "password123"));
	}
	
	
	

}
