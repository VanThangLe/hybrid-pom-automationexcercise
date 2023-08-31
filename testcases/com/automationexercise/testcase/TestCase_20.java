package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.CartPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_20 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	SignupLoginPageObject signupLoginPage;
	SignupPageObject signupPage;
	ProductsPageObject productsPage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 20: Search Products and Verify Cart After Login")
	public void Testcase_20() {
		log.info("Testcase_20 - Step 01: Click on 'Products' button");
		
		
		log.info("Testcase_20 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		
		
		log.info("Testcase_20 - Step 03: Enter product name in search input and click search button");
		
		
		log.info("Testcase_20 - Step 04: Verify 'SEARCHED PRODUCTS' is visible");
		
		
		log.info("Testcase_20 - Step 05: Verify all the products related to search are visible");
		
		
		log.info("Testcase_20 - Step 06: Add those products to cart");
		
		
		log.info("Testcase_20 - Step 07: Click 'Cart' button and verify that products are visible in cart");
		
		
		log.info("Testcase_20 - Step 08: Click 'Signup / Login' button and submit login details");
		
		
		log.info("Testcase_20 - Step 09: Again, go to Cart page");
		
		
		log.info("Testcase_20 - Step 10: Verify that those products are visible in cart after login as well");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
