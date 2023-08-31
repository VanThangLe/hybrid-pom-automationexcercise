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

public class TestCase_23 extends BaseTest {
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
	
	@Test(description = "Test Case 23: Verify address details in checkout page")
	public void Testcase_23() {
		log.info("Testcase_23 - Step 01: Click 'Signup / Login' button");
		
		
		log.info("Testcase_23 - Step 02: Fill all details in Signup and create account");
		
		
		log.info("Testcase_23 - Step 03: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		
		
		log.info("Testcase_23 - Step 04: Verify ' Logged in as username' at top");
		
		
		log.info("Testcase_23 - Step 05: Add products to cart");
		
		
		log.info("Testcase_23 - Step 06: Click 'Cart' button");
		
		
		log.info("Testcase_23 - Step 07: Verify that cart page is displayed");
		
		
		log.info("Testcase_23 - Step 08: Click Proceed To Checkout");
		
		
		log.info("Testcase_23 - Step 09: Verify that the delivery address is same address filled at the time registration of account");
		
		
		log.info("Testcase_23 - Step 10: Verify that the billing address is same address filled at the time registration of account");
		
		
		log.info("Testcase_23 - Step 11: Click 'Delete Account' button");
		
		
		log.info("Testcase_23 - Step 12: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
