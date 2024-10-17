package com.omr.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassAPI {
	RequestSpecification reqSpec;
	Response response;
	
	public static String getProjectPath() {
		return System.getProperty("user.dir");
		

	}
	
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "/Configure/Configure.properties"));
		String value = (String) properties.getProperty(key);
		return value;
		
	}

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
	public void addHeaders(Headers headers) {
		reqSpec=RestAssured.given().headers(headers);
		
	}

	public void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}
	public void addbody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public Response addReqType(String reqType, String endPoint) {
		switch (reqType) {
		case "GET":
			response = reqSpec.get(endPoint);
			break;
		case "POST":
			response = reqSpec.post(endPoint);
			break;
		case "PUT":
			response = reqSpec.put(endPoint);
			break;
		case "PATCH":
			response = reqSpec.patch(endPoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endPoint);
			break;
		default:
			break;

		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	public void addBasicAuth(String username, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(username, password);

	}

}
