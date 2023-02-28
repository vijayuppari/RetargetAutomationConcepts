package com.jackson.java;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsontoPojoandchangedefaultvalueswithoutpojo {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> readValue = objectMapper.readValue(new File("C:\\Users\\Vijay\\workspace\\RestAssuredProject\\src\\test\\java\\resources\\address.json"), 
				new TypeReference<Map<String,Object>>(){});
		
		System.out.println(readValue.get("area"));
		
		readValue.put("Pin", 500010);
		System.out.println(readValue.get("Pin"));
		
		readValue.put("Langitude", 84641.54);
		System.out.println(readValue.get("Langitude"));
		
		
		// Verify Its City really updated or not
		
		String writeValueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(readValue);
		System.out.println(writeValueAsString);
		
	}

}
