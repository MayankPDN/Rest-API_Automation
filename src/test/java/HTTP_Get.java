import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTP_Get {
	
	@Test

	void httpget1() {
		
		//step 1 specify Endpoint/ Base URL
		
		RestAssured.baseURI="http://reqres.in";
		
		//step 2 create request object for type of request
		
		RequestSpecification httprequest=RestAssured.given();
		
		//step 3 Create response object
		
		Response httpresponse= httprequest.request(Method.GET,"/api/users?page=2");
		
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
