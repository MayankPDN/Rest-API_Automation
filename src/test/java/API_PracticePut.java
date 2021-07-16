import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_PracticePut {

	@Test
	public void test() {
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest= RestAssured.given();
		
		//Step 3 create responce object, and pass Payload.
				// create payload
		
		JSONObject RequestUltilityxyz= new JSONObject();
		
		RequestUltilityxyz.put("name", "morpheus");
		RequestUltilityxyz.put("job", "zion resident");
		
		httprequest.header("Content.type","application/json");
		httprequest.body(RequestUltilityxyz.toJSONString());
		
		Response httpresponse= httprequest.request(Method.PATCH,"/api/users/2");
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
