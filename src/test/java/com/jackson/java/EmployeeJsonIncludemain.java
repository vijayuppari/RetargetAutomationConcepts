package com.jackson.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class EmployeeJsonIncludemain {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		
		
		EmployeePojo_Jsoninclude employeePojo_Jsoninclude = new EmployeePojo_Jsoninclude();
		employeePojo_Jsoninclude.setEmpid(12333);
		employeePojo_Jsoninclude.setEmpage(0);
		employeePojo_Jsoninclude.setEmpname("Vijay");
		employeePojo_Jsoninclude.setSalary(231447);
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojo_Jsoninclude);
		System.out.println(writeValueAsString);
		
		
		
		
	}

}
