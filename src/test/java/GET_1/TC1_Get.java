package GET_1;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

public class TC1_Get {
	
	
	// Json. gson, Jackson, Json beatifier, Json Path and Json Simple
	
	
	
	@Test(enabled=false)
	void test1(){
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body().asString());
	}

	
	@Test (enabled=true)
	void test2(){
		given().
		header("content-type","application-json").
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200)
		.body("data.id[0]", equalTo(7))
		.body("data.first_name", hasItems("Michael","Lindsay"));
	}
	
	
	@Test(enabled=false)
	void testlogall(){
		given().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).log().all();
	}
}
