package com.framework.servicenow.tests.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC001_CreateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Create Incident";
		testDescription = "Create Incident using REST API";
		authors = "Karthikeyan";
		category = "REST";
	
	}

	@Test
	public void createIncident() {			
		Response response = postWithJsonAsBody("{\n"
				+ "    \"fields\": {\n"
				+ "        \"project\": {\n"
				+ "            \"key\": \"TSTCT2023\"\n"
				+ "        },\n"
				+ "        \"summary\": \"create issue in RA project\",\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\n"
				+ "        \"issuetype\": {\n"
				+ "            \"name\": \"Bug\"\n"
				+ "        }\n"
				+ "    }\n"
				+ "}", "issue");
		response.prettyPrint();
		verifyContentType(response, "application/json");
		verifyResponseCode(response, 201);	

	}

		
		
		
	}























