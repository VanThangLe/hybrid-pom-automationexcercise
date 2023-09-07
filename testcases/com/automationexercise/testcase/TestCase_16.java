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
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.PaymentPageObject;
import pageObjects.automationexercise.ProductsPageObject;
import pageObjects.automationexercise.RegisterPageObject;

public class TestCase_16 extends BaseTest {
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
	
	@Test(description = "Test Case 16: Place Order: Login before Checkout")
	public void Testcase_16() {
		log.info("Testcase_16 - Step 01: Click 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_16 - Step 02: Fill email, password and click 'Login' button");
		signupLoginPage.enterToTextboxByDataQA(driver, "login-email", Data.Testcase_01.USER_NAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "login-password", Data.Testcase_01.PASSWORD);
		signupLoginPage.clickToButtonByDataQA(driver, "login-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_16 - Step 03: Verify 'Logged in as username' at top");
		verifyTrue(homePage.isTitleTextDisplayed(driver, "Logged in as " + Data.Testcase_01.USER_NAME));
		
		log.info("Testcase_16 - Step 04: Add products to cart");
		homePage.addProductToCartInProductLists(driver, "1");
		
		log.info("Testcase_16 - Step 05: Click 'Cart' button");
		homePage.getWindowHanle(driver);
		homePage.clickToButtonByTitle(driver, "Continue Shopping");
		homePage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_16 - Step 06: Verify that cart page is displayed");
		verifyTrue(cartPage.isTitleTextDisplayed(driver, "Shopping Cart"));
		
		log.info("Testcase_16 - Step 07: Click Proceed To Checkout");
		cartPage.clickToButtonByTitle(driver, "Proceed To Checkout");
		checkoutPage = PageGenerator.getCheckoutPage(driver);
		
		log.info("Testcase_16 - Step 08: Verify Address Details and Review Your Order");
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "2"), Data.Testcase_01.FIRST_NAME + " " + Data.Testcase_01.LAST_NAME);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "3"), Data.Testcase_01.COMPANY);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "4"), Data.Testcase_01.ADDRESS);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "5"), Data.Testcase_01.ADDRESS2);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "6"), Data.Testcase_01.CITY + " " + Data.Testcase_01.STATE + " " + Data.Testcase_01.ZIPCODE);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "7"), Data.Testcase_01.COUNTRY);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "8"), Data.Testcase_01.MOBILE_NUMBER);
		
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "2"), Data.Testcase_01.FIRST_NAME + " " + Data.Testcase_01.LAST_NAME);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "3"), Data.Testcase_01.COMPANY);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "4"), Data.Testcase_01.ADDRESS);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "5"), Data.Testcase_01.ADDRESS2);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "6"), Data.Testcase_01.CITY + " " + Data.Testcase_01.STATE + " " + Data.Testcase_01.ZIPCODE);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "7"), Data.Testcase_01.COUNTRY);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "8"), Data.Testcase_01.MOBILE_NUMBER);
		
		log.info("Testcase_16 - Step 09: Enter description in comment text area and click 'Place Order'");
		checkoutPage.enterToTextareaByIDName(driver, "message", Data.Testcase_14.MESSAGE);
		checkoutPage.clickToButtonByTitle(driver, "Place Order");
		paymentPage = PageGenerator.getPaymentPage(driver);
		
		log.info("Testcase_16 - Step 10: Enter payment details: Name on Card, Card Number, CVC, Expiration date");
		paymentPage.enterToTextboxByDataQA(driver, "name-on-card", Data.Testcase_14.NAME_ON_CARD);
		paymentPage.enterToTextboxByDataQA(driver, "card-number", Data.Testcase_14.CARD_NUMBER);
		paymentPage.enterToTextboxByDataQA(driver, "cvc", Data.Testcase_14.CVC);
		paymentPage.enterToTextboxByDataQA(driver, "expiry-month", Data.Testcase_14.EXPIRATION_MONTH);
		paymentPage.enterToTextboxByDataQA(driver, "expiry-year", Data.Testcase_14.EXPIRATION_YEAR);
		
		log.info("Testcase_16 - Step 11: Click 'Pay and Confirm Order' button");
		paymentPage.clickToButtonByDataQA(driver, "pay-button");
		
		log.info("Testcase_16 - Step 12: Verify success message 'Your order has been placed successfully!'");
		verifyTrue(paymentPage.isTitleTextDisplayed(driver, "Your order has been placed successfully!"));
		orderPlacedPage = PageGenerator.getOrderPlacedPage(driver);
		
		log.info("Testcase_16 - Step 13: Click 'Delete Account' button");
		orderPlacedPage.openMenuPage(driver, "Delete Account");
		deleteAccountPage = PageGenerator.getDeleteAccountPage(driver);
		
		log.info("Testcase_16 - Step 14: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		verifyTrue(deleteAccountPage.isTitleTextDisplayed(driver, "ACCOUNT DELETED!"));
		deleteAccountPage.clickToButtonByDataQA(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
