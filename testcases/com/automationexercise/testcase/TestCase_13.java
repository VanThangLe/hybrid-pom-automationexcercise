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
import pageObjects.automationexercise.ProductsDetailPageObject;
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_13 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductsPageObject productsPage;
	ProductsDetailPageObject productsDetailPage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 13: Verify Product quantity in Cart")
	public void Testcase_13() {
		log.info("Testcase_13 - Step 01: Click 'View Product' for any product on home page");
		
		
		log.info("Testcase_13 - Step 02: Verify product detail is opened");
		
		
		log.info("Testcase_13 - Step 03: Increase quantity to 4");
		
		
		log.info("Testcase_13 - Step 04: Click 'Add to cart' button");
		
		
		log.info("Testcase_13 - Step 05: Click 'View Cart' button");
		
		
		log.info("Testcase_13 - Step 06: Verify that product is displayed in cart page with exact quantity");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
