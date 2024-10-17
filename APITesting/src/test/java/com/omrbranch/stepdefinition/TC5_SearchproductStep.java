package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omr.baseclass.BaseClassAPI;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.payload.product.ProductPayload;
import com.omrbranch.pojo.searchproduct.SearchProduct_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchproductStep extends BaseClassAPI{
	Response response;
	static ProductPayload productPayload = new ProductPayload();
	

	@Given("User add Headers for to SearchProduct")
	public void user_add_headers_for_to_search_product() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
	}

	@When("User add request body for search product {string}")
	public void userAddRequestBodyForSearchProduct(String searchProduct) {
		addbody(productPayload.searchProductPayload(searchProduct));
		System.out.println(searchProduct);
	}



	@When("User send {string} request for SearchProduct endpoint")
	public void user_send_request_for_search_product_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.SEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globleDatas.setStatuscode(statusCode);
		
	}
	@Then("User should verify the SearchProduct response message matches {string}")
	public void user_should_verify_the_search_product_response_message_matches(String expOkMsg) {
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);

		String message = searchProduct_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals("Verify Ok ",expOkMsg,message);
		
	}



}
