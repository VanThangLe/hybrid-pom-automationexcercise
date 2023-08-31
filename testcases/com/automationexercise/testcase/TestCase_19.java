package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_19 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductsPageObject productsPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 19: View & Cart Brand Products")
	public void Testcase_19() {
		log.info("Testcase_19 - Step 01: Click on 'Products' button");
		
		
		log.info("Testcase_19 - Step 02: Verify that Brands are visible on left side bar");
		
		
		log.info("Testcase_19 - Step 03: Click on any brand name");
		
		
		log.info("Testcase_19 - Step 04: Verify that user is navigated to brand page and brand products are displayed");
		
		
		log.info("Testcase_19 - Step 05: On left side bar, click on any other brand link");
		
		
		log.info("Testcase_19 - Step 06: Verify that user is navigated to that brand page and can see products");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
