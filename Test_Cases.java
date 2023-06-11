package AssignmentDemo;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Test_Cases {
	//Get method
	@Test
	public void get() {
		baseURI="http://localhost:3000";
		given().get("/Users").
		then().statusCode(200).log().all();
		}
   //post Method
	@Test
	public void post() {
	JSONObject request=new JSONObject();
	   request.put("firstName","Neha");
	   request.put("lastName", "pal");
	   request.put("city", "Delhi");
	   request.put("subjectId", 3);
	  
	   
		System.out.println(request.toJSONString());
		baseURI="http://localhost:3000";
		
		given().
		  contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
		  post("/Users").
		then().
		  statusCode(201);
	}
     //put method
	@Test
	public void put() {
		JSONObject request=new JSONObject();
		  request.put("firstName","Raj");
		   request.put("lastName", "Pal");
		   request.put("subjectId", "1");
		   
		   
			System.out.println(request.toJSONString());
			baseURI="http://localhost:3000";
			
			given().
			  contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
			  put("/Users/4").
			then().
			  statusCode(200);
	
}
	  //patch method
	@Test
	public void patch() {
		JSONObject request=new JSONObject();
		
		   request.put("lastName", "Singh");	   
			System.out.println(request.toJSONString());
			baseURI="http://localhost:3000";
			
			given().
			  contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
			  patch("/Users/3").
			then().
			  statusCode(200);	
}
	 //Delete method
	@Test
	public void delete() {
		    JSONObject request=new JSONObject();	      
			System.out.println(request.toJSONString());
			baseURI="http://localhost:3000";
			when().
			  delete("/Users/5").
			then().
			  statusCode(200);
	
}
}

