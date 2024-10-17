package com.omrbranch.pojo.address;

import java.util.ArrayList;


public class GetCityList_Output_Pojo {
	private int status;
    private String message;
    private ArrayList<GetCityList> data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<GetCityList> getData() {
		return data;
	}
	public void setData(ArrayList<GetCityList> data) {
		this.data = data;
	}

}
