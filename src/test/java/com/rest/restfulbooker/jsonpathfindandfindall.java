package com.rest.restfulbooker;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;


public class jsonpathfindandfindall {
	
	public static void main(String[] args) {
		
		String fname= System.getProperty("user.dir")+"\\src\\test\\java\\resources\\people.json";
		File file= new File(fname);
		
		JsonPath jsonpath = new JsonPath(file);
		
		// It will return the first name in the index "0"
		System.out.println(jsonpath.getString("[0].first_name"));
		
		// It will return all the firstnames in the array including if firstname is not there it will return "null"
		System.out.println(jsonpath.getString("first_name"));
		
		// 
		List<Object> first_names = jsonpath.getList("findAll{it.gender=='Female'}.first_name");
		System.out.println(first_names);
		
		List<Object> first_names1 = jsonpath.getList("findAll{it}.first_name");
		System.out.println(first_names1);
		
		// And condition
		String getemail = jsonpath.getString("find{it.first_name=='Lothaire' && it.last_name=='Benazet'}.email");
		System.out.println(getemail);
		
		// OR
		String getemailor = jsonpath.getString("find{it.first_name=='Lothaire' || it.last_name=='Hesbrook'}.email");
		System.out.println(getemailor);
		
		// get Size
		System.out.println(jsonpath.getInt("size()"));
		
		
	}

}
