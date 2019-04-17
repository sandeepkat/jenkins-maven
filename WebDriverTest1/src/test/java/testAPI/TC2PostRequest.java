package testAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2PostRequest {

	@Test
	public void registerCustomer()
	{
	RestAssured.baseURI = "http://restapi.demoqa.com/customer";
	RequestSpecification httpRequest = RestAssured.given();
	
	//Specifying request payload in JSON fromat
	JSONObject jobj = new JSONObject();
	jobj.put("Firstname", "Sandy");
	jobj.put("Lastname", "Iyer");
	jobj.put("Username", "Sandy_Iyer");
	jobj.put("Password", "SandyIyer");
	jobj.put("Emal", "SandyI@gmail.com");
	
	httpRequest.header("Content-Type", "application/JSON");
	httpRequest.body(jobj.toJSONString());
	
	Response response = httpRequest.put("/register");
	
	String responseBody = response.getBody().asString();
	System.out.println("Response body is: " + responseBody);
	
	int statusCode = response.getStatusCode();
	System.out.println("Status code is: "+ statusCode);
	
	String responseCode = response.jsonPath().get("SuccessCode");
	System.out.println("Response code is: "+ responseCode);
	
	//validate
	Assert.assertEquals(responseCode, "OPERATION_SUCCESS");
	Assert.assertEquals(statusCode, 201);
	
	}
	
}
