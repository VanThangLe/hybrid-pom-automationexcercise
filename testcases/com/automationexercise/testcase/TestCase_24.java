package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationexercise.data.Data;

import commons.BaseTest;
import pageObjects.automationexercise.AccountCreatedPageObject;
import pageObjects.automationexercise.CartPageObject;
import pageObjects.automationexercise.CheckoutPageObject;
import pageObjects.automationexercise.DeleteAccountPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.OrderPlacedPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.PaymentPageObject;
import pageObjects.automationexercise.ProductsPageObject;
import pageObjects.automationexercise.RegisterPageObject;
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;

public class TestCase_24 extends BaseTest {
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
	PaymentPageObject paymentPage;
	OrderPlacedPageObject orderPlacedPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 24: Download Invoice after purchase order")
	public void Testcase_24() {
		log.info("Testcase_24 - Step 01: Add products to cart");
		homePage.addProductToCartInProductLists(driver, "1");
		
		log.info("Testcase_24 - Step 02: Click 'Cart' button");
		homePage.getWindowHanle(driver);
		homePage.clickToButtonByTitle(driver, "Continue Shopping");
		homePage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_24 - Step 03: Verify that cart page is displayed");
		verifyTrue(cartPage.isTitleTextDisplayed(driver, "Shopping Cart"));
		
		log.info("Testcase_24 - Step 04: Click Proceed To Checkout");
		cartPage.getWindowHanle(driver);
		cartPage.clickToButtonByTitle(driver, "Proceed To Checkout");
		checkoutPage = PageGenerator.getCheckoutPage(driver);
		
		log.info("Testcase_24 - Step 05: Click 'Register / Login' button");
		
		
		log.info("Testcase_24 - Step 06: Fill all details in Signup and create account");
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-name", Data.Testcase_23.USER_NAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-email", Data.Testcase_23.EMAIL);
		signupLoginPage.clickToButtonByDataQA(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByDataQA(driver, "name", Data.Testcase_23.USER_NAME);
		signupPage.enterToTextboxByDataQA(driver, "password", Data.Testcase_01.PASSWORD);
		signupPage.selectItemInDropdownByName(driver, "days", Data.Testcase_01.DAY);
		signupPage.selectItemInDropdownByName(driver, "months", Data.Testcase_01.MONTH);
		signupPage.selectItemInDropdownByName(driver, "years", Data.Testcase_01.YEAR);
		signupPage.clickToCheckboxByID(driver, "newsletter");
		signupPage.clickToCheckboxByID(driver, "optin");
		signupPage.enterToTextboxByDataQA(driver, "first_name", Data.Testcase_23.FIRST_NAME);
		signupPage.enterToTextboxByDataQA(driver, "last_name", Data.Testcase_23.LAST_NAME);
		signupPage.enterToTextboxByDataQA(driver, "company", Data.Testcase_01.COMPANY);
		signupPage.enterToTextboxByDataQA(driver, "address", Data.Testcase_01.ADDRESS);
		signupPage.enterToTextboxByDataQA(driver, "address2", Data.Testcase_01.ADDRESS2);
		signupPage.selectItemInDropdownByName(driver, "country", Data.Testcase_01.COUNTRY);
		signupPage.enterToTextboxByDataQA(driver, "state", Data.Testcase_01.STATE);
		signupPage.enterToTextboxByDataQA(driver, "city", Data.Testcase_01.CITY);
		signupPage.enterToTextboxByDataQA(driver, "zipcode", Data.Testcase_01.ZIPCODE);
		signupPage.enterToTextboxByDataQA(driver, "mobile_number", Data.Testcase_01.MOBILE_NUMBER);
		signupPage.clickToButtonByDataQA(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		log.info("Testcase_24 - Step 07: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		verifyTrue(accountCreatedPage.isTitleTextDisplayed(driver, "ACCOUNT CREATED!"));
		accountCreatedPage.clickToButtonByDataQA(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_24 - Step 08: Verify ' Logged in as username' at top");
		verifyTrue(homePage.isTitleTextDisplayed(driver, "Logged in as " + Data.Testcase_23.USER_NAME));
		
		log.info("Testcase_24 - Step 09: Click 'Cart' button");
		homePage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_24 - Step 10: Click 'Proceed To Checkout' button");
		cartPage.getWindowHanle(driver);
		cartPage.clickToButtonByTitle(driver, "Proceed To Checkout");
		checkoutPage = PageGenerator.getCheckoutPage(driver);
		
		log.info("Testcase_24 - Step 11: Verify Address Details and Review Your Order");
		
		
		log.info("Testcase_24 - Step 12: Enter description in comment text area and click 'Place Order'");
		
		
		log.info("Testcase_24 - Step 13: Enter payment details: Name on Card, Card Number, CVC, Expiration date");
		
		
		log.info("Testcase_24 - Step 14: Click 'Pay and Confirm Order' button");
		
		
		log.info("Testcase_24 - Step 15: Verify success message 'Your order has been placed successfully!'");
		
		
		log.info("Testcase_24 - Step 16: Click 'Download Invoice' button and verify invoice is downloaded successfully.");
		
		
		log.info("Testcase_24 - Step 17: Click 'Continue' button");
		
		
		log.info("Testcase_24 - Step 18: Click 'Delete Account' button");
		
		
		log.info("Testcase_24 - Step 19: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
