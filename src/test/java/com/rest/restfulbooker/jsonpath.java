package com.rest.restfulbooker;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonpath {
	
	// Root node will represent with $
	// Child node is represent using .
	// We can not use [] to represent the child node
	
	@Test
	public  void simplejsonTest(){
	String json="{\"firstname\":\"Jim\",\"lastname\":\"Brown\"}";
	
	JsonPath jsonPath = new JsonPath(json);
	
	String fname =jsonPath.getString("firstname");
	System.out.println(fname);
	
	
	// If we are not clear with datatype then direct use get
	Object firstname = jsonPath.get("firstname");
	System.out.println(firstname);
	
	
	// If we checking for non existing key in json path 
	
	String fname1 =jsonPath.getString("firstname1");// In this case we will get null, because default 
	//value for String is "null"
	System.out.println(fname1);
	
	// Instead of String if we use getInt or other method we will get Nullpointer exception
	
	/*int fname2 =jsonPath.getInt("firstname1");
	System.out.println(fname2);*/

	System.out.println((Object)jsonPath.get("$"));
	
	
	}

}
