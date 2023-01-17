package Dummy;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethods {
	
	@Test
	
	public void Postcall() {
		
		
	RequestSpecification requestspecification=	RestAssured.given();
	requestspecification.basePath("http://localhost:3000");
	requestspecification.baseUri("employees");
	requestspecification.body("id: 12,\n"
			+ "salary: 123456,\n"
			+ "companyName: \"Infogain\",\n"
			+ "name: \"Priya\",\n"
			+ "gender: \"Female\",\n"
			+ "address: [\n"
			+ "{\n"
			+ "city: \"Kolkata\",\n"
			+ "pincode: \"201301\",\n"
			+ "country: \"India\",\n"
			+ "address1: \"defence Enclave\",\n"
			+ "state: \"WB\"\n"
			+ "},\n"
			+ "{\n"
			+ "city: \"Kolkata\",\n"
			+ "pincode: \"700091\",\n"
			+ "country: \"India\",\n"
			+ "address1: \"saltlake\",\n"
			+ "state: \"WB\"");
	
	requestspecification.contentType(ContentType.JSON);
	
	Response response = requestspecification.post();
	response.statusCode();
	}
	
@Test
	
	public void Postcall2() {
	
HashMap<String,Object> hashMap = new HashMap<String,Object>();
hashMap.put("", "");
hashMap.put("", "");
hashMap.put("", "");
hashMap.put("", "");
hashMap.put("", "");


		JsonObject jsonobject= new JsonObject();
		
		
		
	
	}
	
	

}
