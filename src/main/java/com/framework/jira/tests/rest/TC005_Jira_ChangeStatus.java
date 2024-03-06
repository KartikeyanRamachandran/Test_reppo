package com.framework.jira.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC005_Jira_ChangeStatus extends RESTAssuredBase {

	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Change Ticket Status in Jira";
		testDescription = "Change Ticket Status to a jira ticket using REST API";
		authors = "karthikeyan";
		category = "REST";
		//dataProvider
		dataFileName = "TC005_jira";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void ChangeJiraStatus(File file) throws FileNotFoundException, IOException {

		Response response =postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().manageIssue_Path()+"/"+jiraKey+"/transitions");
		verifyResponseCode(response,ConfigurationManager.configuration().put_statuscode());

	}

}
