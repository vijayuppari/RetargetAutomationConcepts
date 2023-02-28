package com.rest.pojo.json;

import io.restassured.RestAssured;

public class covertjsontopojo_Employee {
	
	public static void main(String[] args) {
		
		
		Employee employee = RestAssured.get("https://run.mocky.io/v3/6655340e-1ce1-4255-b6ab-7c83a86d9879").
				as(Employee.class);
		
		System.out.println(employee.getEmpid());
		System.out.println(employee.getEmpname());
		
		
	}

}
