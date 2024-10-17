package com.id;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OmrSample {
	public static void main(String[] args) throws IOException, ParseException {
		// 1.mention the path of json
		FileReader reader = new FileReader(
				"/Users/apple/eclipse-workspace/APITesting/src/test/resources/jsonFile.json");

		// 2. create the object for JSONParser class
		JSONParser jsonparser = new JSONParser();

		// 3. pass the json file to fetch values
		Object parse = jsonparser.parse(reader);

		JSONObject jsonObject = (JSONObject) parse;
		System.out.println(".........data...........");
		//outer
		Object object = jsonObject.get("data");
		System.out.println(object);
		//inner data file
		JSONObject j = (JSONObject) object;
		System.out.println(j.get("id"));
		System.out.println(j.get("flightName"));
		System.out.println(j.get("Country"));
		System.out.println(j.get("Destinations"));
		System.out.println(j.get("URL"));
		System.out.println(j.get("Created_Date"));
		System.out.println(j.get("Updated_Date"));
		
//		JSONObject jsonObject1 = (JSONObject) parse;
		System.out.println(".........support...........");
		
		Object object1 = jsonObject.get("support");
		System.out.println(object1);

		JSONObject j1 = (JSONObject) object1;
		System.out.println(j1.get("url"));
		System.out.println(j1.get("text"));

	}

}
