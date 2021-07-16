import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTP_PostPractice {

	
	@Test
		void http_testAPI() {
		
		RestAssured.baseURI=("https://reqres.in"); // Endpoint/ Base URL
		
		RequestSpecification httprequest = RestAssured.given(); 
		
		JSONObject EnteringdataXYZ = new JSONObject(); // create responce object, and pass Payload.
		
			EnteringdataXYZ.put("email", "eve.holt@reqres.in");;
			EnteringdataXYZ.put("password", "kidXXX");
			
			httprequest.header("Content.type","application/json");
			httprequest.body(EnteringdataXYZ.toJSONString());
			
			Response httpresponse= httprequest.request(Method.PUT,"api/register");
			String response = httpresponse.getBody().asString();
			System.out.println(response);
			
			int code= httpresponse.getStatusCode();// validate status code 200
			System.out.println(code);
		
			Assert.assertEquals(code,200);//Asserting code
			
			String statusline=httpresponse.getStatusLine(); // getting status line
			System.out.println(statusline);
			
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK"); // // validate status line
	}
}
