package com.id;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListFlight {
	    public static void main(String[] args) throws IOException, ParseException {
		// 1.mention the path of json
				FileReader reader = new FileReader("/Users/apple/eclipse-workspace/APITesting/src/test/java/com/id/ListFlight.java");
				JSONParser jsonparser = new JSONParser();
				Object parse = jsonparser.parse(reader);
				
				//get outter data
				JSONObject j1 = (JSONObject) parse;
				System.out.println(j1.get("page"));
				System.out.println(j1.get("per_page"));
				System.out.println(j1.get("total"));
				System.out.println(j1.get("total_pages"));
				System.out.println(".........data...........");
				//outer data
				Object object = j1.get("data");
				System.out.println(object);
				//Get data in array 
				JSONArray array= (JSONArray) object;
				//get inner all data in one condition
				for (int i = 0; i < array.size(); i++) {
					Object object2 = array.get(i);
					JSONObject j2 = (JSONObject) object2;
					
					System.out.println(j2.get("id"));
					System.out.println(j2.get("flightName"));
					System.out.println(j2.get("Country"));					
					System.out.println(j2.get("Destinations"));
					System.out.println(j2.get("URL"));	
				}
				//Get outter Support 
				System.out.println(".........support...........");
				
				Object object1 = j1.get("support");
				System.out.println(object1);
				//support inner 
				JSONObject j3 = (JSONObject) object1;
				System.out.println(j3.get("url"));
				System.out.println(j3.get("text"));

	}

}

