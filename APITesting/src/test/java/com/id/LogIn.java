package com.id;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omr.baseclass.BaseClassAPI;

import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.payload.address.AddressPayload;
import com.omrbranch.payload.product.ProductPayload;
import com.omrbranch.pojo.address.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.AddUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.DeleteUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.DeleteUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.GetCityList;
import com.omrbranch.pojo.address.GetCityList_Input_Pojo;
import com.omrbranch.pojo.address.GetCityList_Output_Pojo;
import com.omrbranch.pojo.address.GetStateList;
import com.omrbranch.pojo.address.GetStateList_Output_Pojo;
import com.omrbranch.pojo.address.GetUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Output_Pojo;
import com.omrbranch.pojo.login.Login_Output_Pojo;
import com.omrbranch.pojo.searchproduct.SearchProduct_Input_Pojo;
import com.omrbranch.pojo.searchproduct.SearchProduct_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class LogIn extends BaseClassAPI {
	String logtoken;
	String address_Id;
	int stateID;
	String stateIDText;
	int cityID;
	String cityIDText;
	String searchProduct;
	static AddressPayload addressPayload = new AddressPayload();
	static ProductPayload productPayload = new ProductPayload();
	
	@Test(priority = 1)
	public void Login() {
		// 1. Header
		addHeader("accept", "application/json");
		// 2. Basic Auth
		addBasicAuth("classwindeva@gmail.com", "Classwin@123");
		// 3. Req Type
		Response response = addReqType("POST", EndPoints.POSTMANBASICAUTHLOGIN);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
		
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Classwin", "Verify last name");

		logtoken = login_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);
	}

	@Test(priority = 4)
	private void addAddressUser() {
		// 1. Add Header
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2.Add User Address Payload
//		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("Classwin", "Deva",
//				"9003332131", "Swara", 10, 0010, 101, "600028", "B303", "Home");
//
//		addbody(addUserAddress_Input_Pojo);
		addbody(addressPayload.addAddressPayload("Classwin", "Deva", "9003332131", "Swara", 10, 0010, 101, "600028", "B303", "Home"));

		// 3.Req Type
		Response response = addReqType("POST", EndPoints.ADDUSERADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		// 4. Get Address ID
		int address_id = addUserAddress_Output_Pojo.getAddress_id();
		address_Id = String.valueOf(address_id);

		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address added successfully", "Verify Address added Sucessfully");

	}

	@Test(priority = 5)
	private void UpdateAddressUser() {
		// 1. Add Header
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
		// 2. Update user address payload
//		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_Id,
//				"Classwin", "Deva", "9003332131", "Swara", 10, 0010, 101, "600028", "B303", """);
//		addbody(updateUserAddress_Input_Pojo);
		addbody(addressPayload.updateUserAddressPayload(address_Id, "Classwin", "Deva", "9003332131", "Swara", 10, 0010, 101, "600028", "B303", "Home"));

		// 3.Req Type
		Response response = addReqType("PUT", EndPoints.UPDATEADDRESSUSER);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);

		String message = updateUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address updated successfully", "Verify Address updated successfully");

	}

	@Test(priority = 6)
	private void getAllAddress() {
		// 1. Add Header
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2.Req Type
		Response response = addReqType("GET", EndPoints.GETALLADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);

		String message = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "OK", "Verify Ok ");

	}

	@Test(priority = 7)
	private void DeleteAddress() {
		// 1. Add Header
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2. Payload
//		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_Id);
//		addbody(deleteUserAddress_Input_Pojo);
		addbody(addressPayload.deleteUseraddressPayload(address_Id));
		
		
		// 3. Req Type
		Response response = addReqType("DELETE", EndPoints.DELETEADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address deleted successfully", "Verify Address deleted successfully");

	}

	@Test(priority = 2)
	public void StateList() {
		addHeader("accept", "application/json");
		Response response = addReqType("GET", EndPoints.STATELIST);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		GetStateList_Output_Pojo getStateList_Output_Pojo = response.as(GetStateList_Output_Pojo.class);

		ArrayList<GetStateList> data = getStateList_Output_Pojo.getData();
		for (GetStateList datum : data) {

			String name = datum.getName();
			if (name.equals("Tamil Nadu")) {
				stateID = datum.getId();
				stateIDText = String.valueOf(stateID);
				System.out.println(stateIDText);
				Assert.assertEquals(stateID, 35, "Verify State Id");

			}

		}

	}

	@Test(priority = 3)
	public void CityList() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		//GetCityList_Input_Pojo getCityList_Input_Pojo = new GetCityList_Input_Pojo(stateIDText);
		//addbody(getCityList_Input_Pojo);
		GetCityList_Input_Pojo cityListPayload = addressPayload.getCityListPayload(stateIDText);
		addbody(cityListPayload);
		
		Response response = addReqType("POST", EndPoints.CITYLIST);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		GetCityList_Output_Pojo getCityList_Output_Pojo = response.as(GetCityList_Output_Pojo.class);

		ArrayList<GetCityList> data = getCityList_Output_Pojo.getData();
		for (GetCityList datum : data) {
			String name = datum.getName();
			if (name.equals("Chennai")) {
				cityID = datum.getId();
				cityIDText = String.valueOf(cityID);
				System.out.println(cityIDText);
				Assert.assertEquals(cityID, 3659, "Verify City Id");

			}

		}

	}

	@Test(priority = 8)
	public void SearchProduct() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

//		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo(searchProduct);
//		addbody(searchProduct_Input_Pojo);
		addbody(productPayload.searchProductPayload(searchProduct));

		Response response = addReqType("POST", EndPoints.SEARCHPRODUCT);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);

		String message = searchProduct_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "OK", "Verify Ok ");

	}

}
