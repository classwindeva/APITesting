package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omr.baseclass.BaseClassAPI;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.globledatas.GlobleDatas;
import com.omrbranch.payload.address.AddressPayload;
import com.omrbranch.pojo.address.GetCityList;
import com.omrbranch.pojo.address.GetCityList_Input_Pojo;
import com.omrbranch.pojo.address.GetCityList_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_CityListStep extends BaseClassAPI{
	Response response;
	int cityID; 
	String cityIDText;
	int stateID;
	String stateIDText;
	static AddressPayload addressPayload = new AddressPayload();
	static GlobleDatas globleDatas = new GlobleDatas();

	@Given("User add Headers for to Citylist")
	public void user_add_headers_for_to_citylist() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
	}

	@When("User add request body state id for get city list")
	public void userAddRequestBodyStateIdForGetCityList() {
		GetCityList_Input_Pojo cityListPayload = addressPayload.getCityListPayload(TC1_LoginStep.globleDatas.getStateIDText());
		addbody(cityListPayload);
	}

	@When("User send {string} request for Citylist endpoint")
	public void user_send_request_for_citylist_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.CITYLIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globleDatas.setStatuscode(statusCode);
			
	}
	@Then("User should verify the Citylist response message matches {string} and saved Cityid")
	public void user_should_verify_the_citylist_response_message_matches_and_saved_cityid(String expCityName) {
		GetCityList_Output_Pojo getCityList_Output_Pojo = response.as(GetCityList_Output_Pojo.class);

		ArrayList<GetCityList> data = getCityList_Output_Pojo.getData();
		for (GetCityList datum : data) {
			String name = datum.getName();
			if (name.equals(expCityName)) {
				cityID = datum.getId();
				TC1_LoginStep.globleDatas.setCityID(cityID);;
				cityIDText = String.valueOf(cityID);
				TC1_LoginStep.globleDatas.setCityIDText(cityIDText);
				Assert.assertEquals("Verify City Id",expCityName,name);
				System.out.println(cityID);
				break;
			}

		}
	}




}
