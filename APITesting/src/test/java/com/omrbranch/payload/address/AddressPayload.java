package com.omrbranch.payload.address;

import com.omrbranch.pojo.address.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.DeleteUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.GetCityList_Input_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Input_Pojo;

public class AddressPayload {
	public GetCityList_Input_Pojo getCityListPayload (String stateIDText) {
		GetCityList_Input_Pojo getCityList_Input_Pojo = new GetCityList_Input_Pojo(stateIDText);
		return getCityList_Input_Pojo;
	}
	
	public AddUserAddress_Input_Pojo addAddressPayload(String first_name, String last_name, String mobile, String apartment, int state,
			int city, int country, String zipcode, String address, String address_type) {
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("Classwin", "Deva",
				"9003332131", "Swara", 10, 0010, 101, "600028", "B303", "Home");
		return addUserAddress_Input_Pojo;
		
	}
	
	public UpdateUserAddress_Input_Pojo updateUserAddressPayload(String address_id, String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id,
				"Classwin", "Deva", "9003332131", "Swara", 10, 0010, 101, "600028", "B303", "Home");
		return updateUserAddress_Input_Pojo;
		
		
		
	}
	public DeleteUserAddress_Input_Pojo deleteUseraddressPayload(String address_id) {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);
		return deleteUserAddress_Input_Pojo;
		
	}
	
	
	
	
	
	
	
	
}
