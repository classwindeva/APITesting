package com.omrbranch.pojo.address;

import java.util.ArrayList;

public class GetStateList_Output_Pojo {
	 private int status;
	 private String message;
	 private ArrayList<GetStateList> data;
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
	public ArrayList<GetStateList> getData() {
		return data;
	}
	public void setData(ArrayList<GetStateList> data) {
		this.data = data;
	}

}
