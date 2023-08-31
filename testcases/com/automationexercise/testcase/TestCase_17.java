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
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_17 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductsPageObject productsPage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 17: Remove Products From Cart")
	public void Testcase_17() {
		log.info("Testcase_17 - Step 01: Add products to cart");
		
		
		log.info("Testcase_17 - Step 02: Click 'Cart' button");
		
		
		log.info("Testcase_17 - Step 03: Verify that cart page is displayed");
		
		
		log.info("Testcase_17 - Step 04: Click 'X' button corresponding to particular product");
		
		
		log.info("Testcase_17 - Step 05: Verify that product is removed from the cart");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
