package com.omrbranch.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommonStep {
	@Then("User should verify the statuscode is {int}")
	public void user_should_verify_the_statuscode_is(int expStatusCode) {
	Assert.assertEquals("Verify Status Code", expStatusCode, TC1_LoginStep.globleDatas.getStatuscode());	
	}

}
