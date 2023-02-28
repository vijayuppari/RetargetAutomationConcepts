package GET_1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

// mokoon  and Json server to create fake apis

// those are the site we have to work with fake apis we have to download node js


public class Fakeapis {
	
	
	
	
	@Test(enabled=false)
	void fake1_Get(){
		
		RestAssured.baseURI="http://localhost:3000/";
		given().
		param("name", "Automation").
		get("/Subjects").then().
		statusCode(200).log().all();
	}
	
	@Test(enabled= false)
	void fake2_Post(){
		
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject jobj= new JSONObject();
		jobj.put("firstname", "Jeff");
		jobj.put("lastname", "Paul");
		jobj.put("SubjectID", 1);
		
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(jobj.toJSONString()).
		when().
		post("users").
		then().statusCode(201).log().all();
	}
	
	@Test(enabled= false)
	void fake2_PATCH(){
		
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject jobj= new JSONObject();
		jobj.put("lastname", "Eric");		
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(jobj.toJSONString()).
		when().
		patch("users/3").
		then().statusCode(200).log().all();
	
	}
	
	@Test(enabled= false)
	void fake2_Put(){
		
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject jobj= new JSONObject();
		jobj.put("firstname", "Sravs");
		jobj.put("lastname", "Alli");
		jobj.put("SubjectID", 1);	
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(jobj.toJSONString()).
		when().
		put("users/2").
		then().statusCode(200).log().all();
	
	}
	
	@Test(enabled=true)
	void fake_delete(){
		
		RestAssured.baseURI="http://localhost:3000/";
		
		given().
		delete("http://localhost:3000/users/5");
		
		
	}
	
	

}
