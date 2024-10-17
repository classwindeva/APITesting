package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omr.baseclass.BaseClassAPI;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.payload.address.AddressPayload;
import com.omrbranch.pojo.address.AddUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.DeleteUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.GetUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClassAPI{
	Response response;
	int address_id;
	static String address_Id;
	String logtoken;
	static AddressPayload addressPayload = new AddressPayload();
	
	//Address Header
	@Given("User add header and bearer authorization for accessing address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globleDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	    
	}


	//Add Address
	@When("User add request body for add new address {string},{string},{string},{string}, {int} , {int}, {int} ,{string},{string},{string}")
	public void userAddRequestBodyForAddNewAddress(String firstName, String lastName, String mobileNumber, String appt, Integer stateID, Integer cityID, Integer countryID, String zipcode, String address, String addressType) {
		addbody(addressPayload.addAddressPayload(firstName, lastName, mobileNumber, appt,TC1_LoginStep.globleDatas.getStateID(), TC1_LoginStep.globleDatas.getCityID(),
				countryID, zipcode, address, addressType));
	}

	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.ADDUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globleDatas.setStatuscode(statusCode);
		
	}
	
	@Then("User should verify the addUserAddress response message macthes {string}")
	public void user_should_verify_the_add_user_address_response_message_macthes(String expAddressMsg) {
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		// 4. Get Address ID
		address_id = addUserAddress_Output_Pojo.getAddress_id();
		address_Id = String.valueOf(address_id);

		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address added Sucessfully",expAddressMsg,message);
	
	}


	
	//Update Address
	
	@When("User add request body for update new address {string},{string},{string},{string},{string}, {int} , {int} , {int} ,{string},{string},{string}")
	public void userAddRequestBodyForUpdateNewAddress(String string, String firstName, String lastName, String mobileNumber, String appt, Integer stateID, Integer cityID, Integer countryID, String zipcode, String address, String addressType) {
		addbody(addressPayload.updateUserAddressPayload(address_Id,firstName, lastName, mobileNumber, appt,TC1_LoginStep.globleDatas.getStateID(), TC1_LoginStep.globleDatas.getCityID(),
				countryID, zipcode, address, addressType));
	}



	@When("User send {string} request for update addUserAddress endpoint")
	public void userSendRequestForUpdateAddUserAddressEndpoint(String reqType) {
		response = addReqType(reqType, EndPoints.UPDATEADDRESSUSER);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globleDatas.setStatuscode(statusCode);
	   
	}
	@Then("User should verify the update addUserAddress response message macthes {string}")
	public void userShouldVerifyTheUpdateAddUserAddressResponseMessageMacthes(String expUpdateMsg) {
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);

		String message = updateUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address updated successfully",expUpdateMsg,message);
	    
	}
	
	
	
	//Get all address
	@When("User send {string} request for get allUserAddress endpoint")
	public void userSendRequestForGetAllUserAddressEndpoint(String reqType) {
		response = addReqType(reqType, EndPoints.GETALLADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globleDatas.setStatuscode(statusCode);    
	}
	@Then("User should verify the get all userAddress response message macthes {string}")
	public void userShouldVerifyTheGetAllUserAddressResponseMessageMacthes(String expOkMsg) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);

		String message = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Ok ",expOkMsg,message);
	   
	}






	
		
	
	
	
	//Delete Address
	@When("User add request body for add new address {string}")
	public void userAddRequestBodyForAddNewAddress(String string) {
		addbody(addressPayload.deleteUseraddressPayload(address_Id));
	}
	@When("User send {string} request for delete UserAddress endpoint")
	public void userSendRequestForDeleteUserAddressEndpoint(String reqType) {
		response = addReqType(reqType, EndPoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globleDatas.setStatuscode(statusCode);    
	}
	@Then("User should verify the delete UserAddress response message macthes {string}")
	public void userShouldVerifyTheDeleteUserAddressResponseMessageMacthes(String expOkMsg) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Ok ",expOkMsg,message);
	    
	}










}
