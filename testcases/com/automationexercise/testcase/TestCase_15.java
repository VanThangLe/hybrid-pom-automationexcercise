package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.AccountCreatedPageObject;
import pageObjects.automationexercise.CartPageObject;
import pageObjects.automationexercise.CheckoutPageObject;
import pageObjects.automationexercise.DeleteAccountPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.ProductsPageObject;
import pageObjects.automationexercise.RegisterPageObject;

public class TestCase_15 extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	SignupLoginPageObject signupLoginPage;
	SignupPageObject signupPage;
	AccountCreatedPageObject accountCreatedPage;
	DeleteAccountPageObject deleteAccountPage;
	ProductsPageObject productsPage;
	CartPageObject cartPage;
	CheckoutPageObject checkoutPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 15: Place Order: Register before Checkout")
	public void Testcase_15() {
		log.info("Testcase_15 - Step 01: Click 'Signup / Login' button");
		
		
		log.info("Testcase_15 - Step 02: Fill all details in Signup and create account");
		
		
		log.info("Testcase_15 - Step 03: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		
		
		log.info("Testcase_15 - Step 04: Verify ' Logged in as username' at top");
		
		
		log.info("Testcase_15 - Step 05: Add products to cart");
		
		
		log.info("Testcase_15 - Step 06: Click 'Cart' button");
		
		
		log.info("Testcase_15 - Step 07: Verify that cart page is displayed");
		
		
		log.info("Testcase_15 - Step 08: Click Proceed To Checkout");
		
		
		log.info("Testcase_15 - Step 09: Verify Address Details and Review Your Order");
		
		
		log.info("Testcase_15 - Step 10: Enter description in comment text area and click 'Place Order'");
		
		
		log.info("Testcase_15 - Step 11: Enter payment details: Name on Card, Card Number, CVC, Expiration date");
		
		
		log.info("Testcase_15 - Step 12: Click 'Pay and Confirm Order' button");
		
		
		log.info("Testcase_15 - Step 13: Verify success message 'Your order has been placed successfully!'");
		
		
		log.info("Testcase_15 - Step 14: Click 'Delete Account' button");
		
		
		log.info("Testcase_15 - Step 15: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
