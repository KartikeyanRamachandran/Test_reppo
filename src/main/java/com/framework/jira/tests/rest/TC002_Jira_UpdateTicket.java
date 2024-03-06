package com.framework.jira.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC002_Jira_UpdateTicket extends RESTAssuredBase {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Update issue in Jira";
		testDescription = "Update issue in jira using REST API";
		authors = "karthikeyan";
		category = "REST";
		//dataProvider
		dataFileName = "TC002_jira";
	    dataFileType = "JSON";
	}
	
	@Test(dataProvider = "fetchData")
	public void updateJira(File file) throws FileNotFoundException, IOException {
		
		Response response = putWithFileBodyAndURL(file, ConfigurationManager.configuration().issue_Path()+"/"+jiraKey);
		response.prettyPrint();
		verifyResponseCode(response,ConfigurationManager.configuration().put_statuscode());
		
	
	}
}
