package TestDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Post_test {
	@Test

	public void testPost() {
	
JSONObject request=new JSONObject();
   request.put("name","Dolly");
   request.put("job", "Doctor");
	System.out.println(request.toJSONString());
	baseURI="https://reqres.in/api";
	
	given().
	  body(request.toJSONString()).
	when().
	  post("/users").
	then().
	  statusCode(201).log().all();

	}
}
