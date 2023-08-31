package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.CartPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;

public class TestCase_22 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 22: Add to cart from Recommended items")
	public void Testcase_22() {
		log.info("Testcase_22 - Step 01: Scroll to bottom of page");
		homePage.scrollToBottomPage(driver);
		
		log.info("Testcase_22 - Step 02: Verify 'RECOMMENDED ITEMS' are visible");
		verifyTrue(homePage.isTitleTextDisplayed(driver, "RECOMMENDED ITEMS"));
		
		log.info("Testcase_22 - Step 03: Click on 'Add To Cart' on Recommended product");
		homePage.cl
		
		log.info("Testcase_22 - Step 04: Click on 'View Cart' button");
		
		
		log.info("Testcase_22 - Step 05: Verify that product is displayed in cart page");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
