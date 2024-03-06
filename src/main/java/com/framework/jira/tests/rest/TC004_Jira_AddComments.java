package com.framework.jira.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC004_Jira_AddComments extends RESTAssuredBase {

	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Add comments in Jira";
		testDescription = "Add comments to a jira ticket using REST API";
		authors = "karthikeyan";
		category = "REST";
		//dataProvider
		dataFileName = "TC004_jira";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void AddComments(File file) throws FileNotFoundException, IOException {

		Response response =postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().manageIssue_Path()+"/"+jiraKey+"/comment");
		verifyResponseCode(response,ConfigurationManager.configuration().post_statuscode());

	}

}
