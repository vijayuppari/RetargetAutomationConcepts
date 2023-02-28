package com.rest.restfulbooker;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonpathnested {
	
	@Test(enabled=false)
	public void nestedjson1() {
		
		String jsonObject = "{\r\n" + 
				"  \"firstName\" : \"amod\",\r\n" + 
				"  \"lastName\" : \"mahajan\",\r\n" + 
				"  \"age\" : 28,\r\n" + 
				"  \"address\" : {\r\n" + 
				"    \"flatNo\" : 401,\r\n" + 
				"    \"buildingName\" : \"ABC\",\r\n" + 
				"    \"streetName\" : \"XYZ\",\r\n" + 
				"    \"pin\" : 123456\r\n" + 
				"  },\r\n" + 
				"  \"salary\" : 10.50,\r\n" + 
				"  \"married\" : false\r\n" + 
				"}";
		
		JsonPath jpath= new JsonPath(jsonObject);
		
		System.out.println(jpath.getString("firstName"));
		System.out.println((Object)jpath.get("married"));
		System.out.println((Object)jpath.get("address.flatNo"));
		
		System.out.println((Object)jpath.get("address.pin"));
		
		
		
	}
	
	@Test(enabled=false)
	public void nestedjsonexample2(){
		
		String strjson="{\"firstName\":\"John\",\"lastName\":\"doe\",\"age\":26,\"address\":{\"streetAddress\":\"naiststreet\",\"city\":\"Nara\","
				+ "\"postalCode\":\"630-0192\"},\"phoneNumbers\":[{\"type\":\"iPhone\","
				+ "\"number\":\"0123-4567-8888\"},{\"type\":\"home\",\"number\":\"0123-4567-8910\"}]}";
		
		JsonPath jpath= new JsonPath(strjson);
     	System.out.println((Object)jpath.get("phoneNumbers[1].type"));
	
	}
	
	@Test(enabled=false)
	public void nestedjsonexample3(){
		
		String jsonarr = "[\"10\",\"20\",\"30\",\"40\",\"50\"]";
		JsonPath jpath= new JsonPath(jsonarr);
		System.out.println(jpath.getString("[0]"));
		
		// size of array
		System.out.println(jpath.getList("$").size());
		
	}
	
	@Test(enabled=false)
	public void nestedjsonexample4(){
		
		String jsonarr = "[[\"10\",\"20\",\"30\",\"40\",\"50\"],[\"100\",\"200\",\"300\",\"400\",\"500\"]]";
		JsonPath jpath= new JsonPath(jsonarr);
		System.out.println(jpath.getString("[0][3]"));
		System.out.println(jpath.getString("[1][3]"));
		
		
		// size of array
		System.out.println(jpath.getList("$").size());
		
	}
	

	@Test
	public void nestedjosnarrays(){
		
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"amod\",\r\n" + 
				"    \"lastName\": \"mahajan\",\r\n" + 
				"    \"age\": 28,\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Benagluru\",\r\n" + 
				"        \"country\": \"India\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Delhi\",\r\n" + 
				"        \"country\": \"India\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"city1\": \"Delhi1\",\r\n" + 
				"        \"country1\": \"India1\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Mukesh\",\r\n" + 
				"    \"lastName\": \"Otwani\",\r\n" + 
				"    \"age\": 31,\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Bhopal\",\r\n" + 
				"        \"country\": \"India\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Delhi\",\r\n" + 
				"        \"country\": \"India\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";
		
		
		JsonPath jpath= new JsonPath(jsonArray);
		System.out.println((Object)jpath.getJsonObject("$"));
		
		System.out.println((Object)jpath.get("[0].address.city[0]"));
		
		System.out.println((Object)jpath.get("[1].address.city[1]"));
		
		System.out.println((Object)jpath.get("[0].address.city[0]"));
		
		System.out.println((Object)jpath.get("address.city"));
	}
	
	
	
}
