package com.omrbranch.payload.product;

import com.omrbranch.pojo.searchproduct.SearchProduct_Input_Pojo;

public class ProductPayload {
	public SearchProduct_Input_Pojo searchProductPayload(String searchProduct) {
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo(searchProduct);
		return searchProduct_Input_Pojo;
		
	}

}
