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

public class TestCase_18 extends BaseTest {
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
	
	@Test(description = "Test Case 18: View Category Products")
	public void Testcase_18() {
		log.info("Testcase_18 - Step 01: Click on 'Women' category");
		
		
		log.info("Testcase_18 - Step 02: Click on any category link under 'Women' category, for example: Dress");
		
		
		log.info("Testcase_18 - Step 03: Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");
		
		
		log.info("Testcase_18 - Step 04: On left side bar, click on any sub-category link of 'Men' category");
		
		
		log.info("Testcase_18 - Step 05: Verify that user is navigated to that category page");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
