package Data;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Datadriventesting  extends Dataaproviders{
	
	
	//@Test(dataProvider="DeleteData")
	void deletecall(int userids){
		
		RestAssured.baseURI="http://localhost:3000/";
		given().
		delete("users/"+userids).then().statusCode(204).log().all();
		
	}
	
	// Incase we want to us parameters for less data below approach
	@Parameters({"UserID"})
	@Test
	void deletecall_param(int userids){
		
		RestAssured.baseURI="http://localhost:3000/";
		given().
		delete("users/"+userids).then().statusCode(204).log().all();	
	}
		
	
	//@Test(dataProvider="DatforPost")
	void datatesting(String firstname, String lastname,int SubjectID){
	RestAssured.baseURI="http://localhost:3000/";
	
	JSONObject jobj= new JSONObject();
	jobj.put("firstname", firstname);
	jobj.put("lastname", lastname);
	jobj.put("SubjectID", SubjectID);	
	given().
	contentType(ContentType.JSON).accept(ContentType.JSON).
	body(jobj.toJSONString()).
	when().
	post("users").
	then().statusCode(201).log().all();

}
	
}
