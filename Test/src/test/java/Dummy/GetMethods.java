package Dummy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethods {
@Test
	
	public void getCall() {
		
	RequestSpecification requestspecification=	RestAssured.given();
	requestspecification.basePath("http://localhost:3000");
	requestspecification.baseUri("employees");
RestAssured.given()
			.get("http://localhost:3000/employees").then().statusCode(200).log().all();

	
	}
}
