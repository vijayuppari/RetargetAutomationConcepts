package com.rest.jsonexamples;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicresponses {
	
	
	@Test(enabled=false)
	public void handilingerror(){
	Response response = RestAssured.get("https://run.mocky.io/v3/520fa19e-2a54-4b9f-a86c-2c5fe068793e");
	Map responseasMap = response.as(Map.class);
	System.out.println(responseasMap.keySet());
	
	
	// In this case we will get Mismatch exception becasue response as Array [] but we are trying to desrilze to Object that is Map
	// In this case we will use Instanceof like below method
	}
	
	@Test
	public void handilingdynamicrespinse(){
	Response response = RestAssured.get("https://run.mocky.io/v3/520fa19e-2a54-4b9f-a86c-2c5fe068793e");
	Object asobject = response.as(Object.class);
	if(asobject instanceof Map){
		System.out.println(((Map) asobject).keySet());
	}
	else if(asobject instanceof List){
		System.out.println(((List) asobject).size());
	}
	
	}

}
