package com.rest.restfulbooker;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;


public class jsonpathfindandfindallextrafilters {
	
	public static void main(String[] args) {
		
		String fname= System.getProperty("user.dir")+"\\src\\test\\java\\resources\\peopleextrafilters.json";
		File file= new File(fname);
		
		JsonPath jsonpath = new JsonPath(file);
		
		// It will return the first name in the index "0"
		System.out.println(jsonpath.getString("data[0].first_name"));
		
		// It will return all the firstnames in the array including if firstname is not there it will return "null"
		System.out.println(jsonpath.getString("data.first_name"));
		
		// 
		List<Object> first_names = jsonpath.getList("data.findAll{it.gender=='Female'}.first_name");
		System.out.println(first_names);
		
		List<Object> first_names1 = jsonpath.getList("data.findAll{it}.first_name");
		System.out.println(first_names1);
		
		// And condition
		String getemail = jsonpath.getString("data.find{it.first_name=='Lothaire' && it.last_name=='Benazet'}.email");
		System.out.println(getemail);
		
		// OR
		String getemailor = jsonpath.getString("data.find{it.first_name=='Lothaire' || it.last_name=='Hesbrook'}.email");
		System.out.println(getemailor);
		
		// get Size
		System.out.println(jsonpath.getInt("data.size()"));
		
		
	}

}
