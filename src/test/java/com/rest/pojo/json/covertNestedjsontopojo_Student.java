package com.rest.pojo.json;

import io.restassured.RestAssured;

public class covertNestedjsontopojo_Student {
	
	public static void main(String[] args) {
		
		
		studentNestedJson student = RestAssured.get("https://run.mocky.io/v3/4daed635-9da5-4ed3-b1eb-931455f245a5").
				as(studentNestedJson.class);
		
		System.out.println(student.getId());
		System.out.println(student.getDepartment());
		System.out.println(student.getAddress().getCity());
		
	}

}
