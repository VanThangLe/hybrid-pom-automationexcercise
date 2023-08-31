package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;

public class TestCase_25 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
	public void Testcase_25() {
		log.info("Testcase_25 - Step 01: Scroll down page to bottom");
		
		
		log.info("Testcase_25 - Step 02: Verify 'SUBSCRIPTION' is visible");
		
		
		log.info("Testcase_25 - Step 03: Click on arrow at bottom right side to move upward");
		
		
		log.info("Testcase_25 - Step 04: Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
