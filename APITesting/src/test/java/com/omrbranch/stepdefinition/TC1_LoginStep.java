package com.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omr.baseclass.BaseClassAPI;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.globledatas.GlobleDatas;
import com.omrbranch.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClassAPI {
	Response response;
	static GlobleDatas globleDatas = new GlobleDatas();
	
	@Given("User add Header")
	public void user_add_header() {
		addHeader("accept", "application/json");
		
	}
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		addBasicAuth(getPropertyFileValue("username"), getPropertyFileValue("password") );
		
	}

	@When("User send {string} request for Login endpoint")
	public void userSendRequestForLoginEndpoint(String reqType) {
		response = addReqType(reqType, EndPoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		globleDatas.setStatuscode(statusCode);
	    
	}

	@Then("User should verify the login response body firstname present as {string} and get the logtoken saved")
	public void user_should_verify_the_login_response_body_firstname_present_as_and_get_the_logtoken_saved(String expFirstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		
		String first_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("Verify last name",expFirstName,first_name);

		String logtoken = login_Output_Pojo.getData().getLogtoken();
		TC1_LoginStep.globleDatas.setLogtoken(logtoken);
		
		
		
	}




}
