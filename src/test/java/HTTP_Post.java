import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTP_Post {

	@Test
	
	void Post_Req() {
		
		//step 1 specify Endpoint/ Base URL
		
		RestAssured.baseURI="https://reqres.in";
		
		//step 2 create request object for type of request
		
		RequestSpecification httprequest=RestAssured.given();
		
		//Step 3 create responce object, and pass Payload.
		// create payload
		
		JSONObject RequestEntitityxyz = new JSONObject();
		
		RequestEntitityxyz.put("name","morpheus");
		RequestEntitityxyz.put("job","leaderxx");
		
		//specify format
		
		httprequest.header("Content.type","application/json");
		
		// value in payload will be converted into json format
		
		httprequest.body(RequestEntitityxyz.toJSONString());
		
		Response httpresponse= httprequest.request(Method.POST,"/api/users");
		String response=httpresponse.getBody().asString();
		System.out.println(response);
		
		//validate status code
		
		
				int Code=httpresponse.getStatusCode(); //201
				
				System.out.println(Code);
				// Insert Assert to verify autometicaly
				
				Assert.assertEquals(Code,201);
				//Fetching Status
				String statusline=httpresponse.getStatusLine();
				System.out.println(statusline);
				
				// validate status line 
				
				Assert.assertEquals(statusline, "HTTP/1.1 201 Created");
		
		
		
	}
}
