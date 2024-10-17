package com.omrbranch.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.omr.baseclass.BaseClassAPI;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.globledatas.GlobleDatas;
import com.omrbranch.pojo.address.GetStateList;
import com.omrbranch.pojo.address.GetStateList_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TC2_StateListStep extends BaseClassAPI{
	Response response;
	int stateID;
	String stateIDText;
	static GlobleDatas globleDatas = new GlobleDatas();
//	@Given("User add Headers for to statelist")
//	public void user_add_headers_for_to_statelist() {
//		addHeader("accept", "application/json");
//		
//	}
//	@When("User send {string} request for Statelist endpoint")
//	public void user_send_request_for_statelist_endpoint(String reqType) {
//		response = addReqType(reqType, EndPoints.STATELIST);
//		int statusCode = getStatusCode(response);
//		TC1_LoginStep.globleDatas.setStatuscode(statusCode);
//		System.out.println(statusCode);
//		
//	}
//	@Then("User should verify the statelist response message matches {string} and saved stateid")
//	public void user_should_verify_the_statelist_response_message_matches_and_saved_stateid(String expStateId) {
//		GetStateList_Output_Pojo getStateList_Output_Pojo = response.as(GetStateList_Output_Pojo.class);
//
//		ArrayList<GetStateList> data = getStateList_Output_Pojo.getData();
//		for (GetStateList datum : data) {
//
//			String name = datum.getName();
//			if (name.equals(expStateId)) {
//				int stateID = datum.getId();
//				TC1_LoginStep.globleDatas.setStateID(stateID);
//				stateIDText = String.valueOf(stateID);
//				System.out.println(stateIDText);
//				TC1_LoginStep.globleDatas.setStateIDText(stateIDText);    
//				Assert.assertEquals("Verify State Id",expStateId,stateID);
//				System.out.println(stateID); 
//				break;
//			}
//
//		}
//
//	}


	
	@Given("User add Headers for to statelist")
	public void userAddHeadersForToStatelist() {
		addHeader("accept", "application/json");
	   
	}
	@When("User send {string} request for Statelist endpoint")
	public void userSendRequestForStatelistEndpoint(String reqType) {
		response = addReqType(reqType, EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globleDatas.setStatuscode(statusCode);
		System.out.println(statusCode);
	   
	}
	@Then("User should verify the statelist response message matches {string} and saved stateid")
	public void userShouldVerifyTheStatelistResponseMessageMatchesAndSavedStateid(String expStateId) {
		GetStateList_Output_Pojo getStateList_Output_Pojo = response.as(GetStateList_Output_Pojo.class);
		
				ArrayList<GetStateList> data = getStateList_Output_Pojo.getData();
				for (GetStateList datum : data) {
		
					String name = datum.getName();
					if (name.equals("Tamil Nadu")) {
						stateID = datum.getId();
						TC1_LoginStep.globleDatas.setStateID(stateID);
						stateIDText = String.valueOf(stateID);
						System.out.println(stateIDText);
						TC1_LoginStep.globleDatas.setStateIDText(stateIDText);    
						Assert.assertEquals("Verify State Id",expStateId,name);
						System.out.println(stateID); 
						break;
					}
	   
	}

	}


	
	
}
