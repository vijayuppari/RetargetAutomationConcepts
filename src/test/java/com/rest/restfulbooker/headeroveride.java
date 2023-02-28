package com.rest.restfulbooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

public class headeroveride {
	
	// We can not merge 2 headers those are "content Type and Accept" by default in RestAssured those are not merged
	
	
	
	@Test (enabled=false)
	public void headerwithoutoveride(){
		
		RestAssured.given().
		header("Header1","value1").
		header("Header1","value22").
		log().all().
		when().
		get();
		
		
	}
	
	@Test(enabled=false)
	public void headerwithoveride(){
		
		RestAssured.given().
		config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().
				overwriteHeadersWithName("Header1","Header3"))).
		
		// If we configured multiple configuration latest configuration
		
		config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().
				mergeHeadersWithName("Header1"))).
		
		header("Header1","value1").
		header("Header1","value22").
		header("Header3","value5").
		header("Header3","value6").
		header("Header5","value100").
		header("Header5","value200").
		log().all().
		when().
		get();
		
	}
	
	@Test(enabled=true)
	public void headeroverrideapproac2(){
		
		
		RequestSpecification res1 = RestAssured.given().header("Header1", "value1");
		RequestSpecification res2 = RestAssured.given().header("Header1", "value3").
														header("Header2", "value2");
		
		
		RestAssured.given().config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().
				overwriteHeadersWithName("Header1"))).
		spec(res1).spec(res2).
		log().all().
		when().get();
			
	}

}
