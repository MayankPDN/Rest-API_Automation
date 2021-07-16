import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTP_Practice {

	
	
	@Test
	void http_PutPractice() {
		
		//step 1 specify Endpoint/ Base URL
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest= RestAssured.given();
		
		//Step 3 create responce object, and pass Payload.
				// create payload
		
		JSONObject RequestUltilityxyz= new JSONObject();
		
		RequestUltilityxyz.put("name", "Dev");
		RequestUltilityxyz.put("job", "kid");
		
		httprequest.header("Content.type","application/json");
		httprequest.body(RequestUltilityxyz.toJSONString());
		
		Response httpresponse= httprequest.request(Method.PUT,"/api/users");
		String response=httpresponse.getBody().asString();
		System.out.println(response);
		
		//validate status code
		
		
				int Code=httpresponse.getStatusCode(); //200
				
				System.out.println(Code);
				// Insert Assert to verify autometicaly
				
				Assert.assertEquals(Code,200);
				//Fetching Status
				String statusline=httpresponse.getStatusLine();
				System.out.println(statusline);
				
				// validate status line 
				
				Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
}	
