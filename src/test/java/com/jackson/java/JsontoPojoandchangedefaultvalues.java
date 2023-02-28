package com.jackson.java;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsontoPojoandchangedefaultvalues {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Address readValueasjosn = objectMapper.readValue(new File("C:\\Users\\Vijay\\workspace\\RestAssuredProject\\src\\test\\java\\resources\\address.json"), 
				Address.class);
		
		System.out.println(readValueasjosn.getCity());
		readValueasjosn.setCity("Banglore");
		System.out.println(readValueasjosn.getCity());
		
		// Verify Its City really updated or not
		
		String writeValueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(readValueasjosn);
		System.out.println(writeValueAsString);
		
	}

}
