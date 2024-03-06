package com.framework.jira.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC003_Jira_UpdateAssignee extends RESTAssuredBase {

	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Update Assignee in Jira";
		testDescription = "Assigne Assignee to a jira ticket using REST API";
		authors = "karthikeyan";
		category = "REST";
		//dataProvider
		dataFileName = "TC003_jira";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void AddAssignee(File file) throws FileNotFoundException, IOException {

		Response response =putWithFileBodyAndURL(file, ConfigurationManager.configuration().manageIssue_Path()+"/"+jiraKey+"/assignee");
		response.prettyPrint();
		verifyResponseCode(response,ConfigurationManager.configuration().put_statuscode());


	}

}
