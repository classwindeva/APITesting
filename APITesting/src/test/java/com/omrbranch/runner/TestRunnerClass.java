package com.omrbranch.runner;


import org.junit.runner.RunWith;

import com.omr.baseclass.BaseClassAPI;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags= "@SearchProduct",glue= "com.omrbranch.stepdefinition",snippets = SnippetType.CAMELCASE,
features = "/Users/apple/eclipse-workspace/APITesting/src/test/resources/Features/")
public class TestRunnerClass extends BaseClassAPI{
//	@AfterClass
//	public static void AfterClass() {
//		//Reporting
//	}

	

}


