package com.rest.pojo.json;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class convertSimpleJsonArrayresponsetoList {
	
	public static void main(String[] args) {
		
		
		List<Address> addresslist = RestAssured.get("https://run.mocky.io/v3/d55286cc-5293-478f-a506-96e6f2b8b1d3").
		as(new TypeRef<List<Address>>(){});
		
		System.out.println(addresslist.get(0).getArea());
		System.out.println(addresslist.get(1).getArea());
		
	}

}
