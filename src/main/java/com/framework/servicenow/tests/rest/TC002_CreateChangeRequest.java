package com.framework.servicenow.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC002_CreateChangeRequest extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Create Change Request";
		testDescription = "Create Change Request using REST API";
		authors = "kabir";
		category = "REST";
		//dataProvider
		dataFileName = "TC002";
	    dataFileType = "JSON";
	}
	
	@Test(dataProvider = "fetchData")
	public void createChangeRequest(File file) throws FileNotFoundException, IOException {
		
//		Response response = postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().CR_Path());
//		response.prettyPrint();
//		verifyResponseCode(response,ConfigurationManager.configuration().post_statuscode());
		
	
	}

}
