package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.TestCasesPageObject;
import pageObjects.automationexercise.PageGenerator;

public class TestCase_07 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	TestCasesPageObject testCasesPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	
	@Test(description = "Test Case 7: Verify Test Cases Page")
	public void Testcase_07() {
		log.info("Testcase_07 - Step 01: Click on 'Test Cases' button");
		homePage.openMenuPage(driver, "Test Cases");
		testCasesPage = PageGenerator.getTestCasesPage(driver);
		
		log.info("Testcase_07 - Step 02: Verify user is navigated to test cases page successfully");
		verifyEquals(testCasesPage.getPageUrl(driver), "https://automationexercise.com/test_cases");
		testCasesPage.openMenuPage(driver, "Home");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
