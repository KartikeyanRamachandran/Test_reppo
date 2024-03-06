package com.framework.jira.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC006_Jira_DeleteTicket extends RESTAssuredBase {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Delete issue in Jira";
		testDescription = "Delete issue in jira using REST API";
		authors = "karthikeyan";
		category = "REST";
	}
	
	@Test()
	public void deleteJira() throws FileNotFoundException, IOException {
		
		Response response = delete(ConfigurationManager.configuration().issue_Path()+"/"+jiraKey);
		response.prettyPrint();
		verifyResponseCode(response,ConfigurationManager.configuration().delete_statuscode());
		
	
	}
}
