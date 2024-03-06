package com.framework.jira.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC001_Jira_CreateTicket extends RESTAssuredBase {
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Log issue in Jira";
		testDescription = "Create new issue in jira using REST API";
		authors = "karthikeyan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001_jira";
	    dataFileType = "JSON";
	}
 
	@Test(dataProvider = "fetchData")
	public void createIncident(File file) throws FileNotFoundException, IOException {
		
		Response response = postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().issue_Path());
		response.prettyPrint();
		jiraKey = extractResponseContent(response, "key");
		verifyResponseCode(response,ConfigurationManager.configuration().post_statuscode());
		
	
	}

}
