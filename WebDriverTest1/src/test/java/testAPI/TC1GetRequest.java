package testAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;;

public class TC1GetRequest {
 
	@Test
	public void getWeatherDetails()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);
		
		int status = response.getStatusCode();
		System.out.println("Staus code is: "+ status);
		
		String statusLine = response.getStatusLine();
		System.out.println("Staus line is: "+ statusLine);
		
		//validate
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		Assert.assertEquals(String.valueOf(status), "200");
		
		
	}
}
