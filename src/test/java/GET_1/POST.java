package GET_1;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class POST {
	
	@Test(enabled=false)
	void post_Approach1(){
		
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("name", "morpheus");
		map.put("job", "leader");
		
		//System.out.println(map);
		
		JSONObject jobject= new JSONObject(map);
		//System.out.println(jobject); // Some times we will get error like serilation is happening then we can use below line
		System.out.println(jobject.toJSONString()); 
		
	}
	
	@Test(enabled=true)
	void post_approach2(){
		
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("name", "morpheus");
		map.put("job", "leader");
		
		JSONObject jobject= new JSONObject();
		jobject.put("name", "morpheus");
		jobject.put("job", "leader");
		//System.out.println(jobject.toJSONString()); 
		
		given().
		header("Content-Type","application/json").
		body(jobject.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201);
		
		
	}

}
