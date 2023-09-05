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
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_23 - Step 02: Fill all details in Signup and create account");
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-name", Data.Testcase_23.USERNAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-email", Data.Testcase_23.EMAIL);
		signupLoginPage.clickToButtonByDataQA(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByDataQA(driver, "name", Data.Testcase_23.USERNAME);
		signupPage.enterToTextboxByDataQA(driver, "password", Data.Testcase_23.PASSWORD);
		signupPage.selectItemInDropdownByName(driver, "days", Data.Testcase_23.DAY);
		signupPage.selectItemInDropdownByName(driver, "months", Data.Testcase_23.MONTH);
		signupPage.selectItemInDropdownByName(driver, "years", Data.Testcase_23.YEAR);
		signupPage.clickToCheckboxByID(driver, "newsletter");
		signupPage.clickToCheckboxByID(driver, "optin");
		signupPage.enterToTextboxByDataQA(driver, "first_name", Data.Testcase_23.FIRSTNAME);
		signupPage.enterToTextboxByDataQA(driver, "last_name", Data.Testcase_23.LASTNAME);
		signupPage.enterToTextboxByDataQA(driver, "company", Data.Testcase_23.COMPANY);
		signupPage.enterToTextboxByDataQA(driver, "address", Data.Testcase_23.ADDRESS);
		signupPage.enterToTextboxByDataQA(driver, "address2", Data.Testcase_23.ADDRESS2);
		signupPage.selectItemInDropdownByName(driver, "country", Data.Testcase_23.COUNTRY);
		signupPage.enterToTextboxByDataQA(driver, "state", Data.Testcase_23.STATE);
		signupPage.enterToTextboxByDataQA(driver, "city", Data.Testcase_23.CITY);
		signupPage.enterToTextboxByDataQA(driver, "zipcode", Data.Testcase_23.ZIPCODE);
		signupPage.enterToTextboxByDataQA(driver, "mobile_number", Data.Testcase_23.MOBILENUMBER);
		signupPage.clickToButtonByDataQA(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		log.info("Testcase_23 - Step 03: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		verifyTrue(accountCreatedPage.isTitleTextDisplayed(driver, "ACCOUNT CREATED!"));
		accountCreatedPage.clickToButtonByDataQA(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_23 - Step 04: Verify ' Logged in as username' at top");
		verifyTrue(homePage.isTitleTextDisplayed(driver, "Logged in as " + Data.Testcase_23.USERNAME));
		
		log.info("Testcase_23 - Step 05: Add products to cart");
		homePage.addProductToCartInProductLists(driver, "1");
		
		log.info("Testcase_23 - Step 06: Click 'Cart' button");
		homePage.clickToButtonByTitle(driver, "Continue Shopping");
		homePage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_23 - Step 07: Verify that cart page is displayed");
		verifyTrue(cartPage.isTitleTextDisplayed(driver, "Shopping Cart"));
		
		log.info("Testcase_23 - Step 08: Click Proceed To Checkout");
		cartPage.clickToButtonByTitle(driver, "Proceed To Checkout");
		checkoutPage = PageGenerator.getCheckoutPage(driver);
		
		log.info("Testcase_23 - Step 09: Verify that the delivery address is same address filled at the time registration of account");
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "2"), Data.Testcase_23.FIRSTNAME + " " + Data.Testcase_23.LASTNAME);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "3"), Data.Testcase_23.COMPANY);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "4"), Data.Testcase_23.ADDRESS);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "5"), Data.Testcase_23.ADDRESS2);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "6"), Data.Testcase_23.CITY + " " + Data.Testcase_23.STATE + " " + Data.Testcase_23.ZIPCODE);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "7"), Data.Testcase_23.COUNTRY);
		verifyEquals(checkoutPage.getDeliveryAddressValue(driver, "8"), Data.Testcase_23.MOBILENUMBER);
		
		log.info("Testcase_23 - Step 10: Verify that the billing address is same address filled at the time registration of account");
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "2"), Data.Testcase_23.FIRSTNAME + " " + Data.Testcase_23.LASTNAME);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "3"), Data.Testcase_23.COMPANY);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "4"), Data.Testcase_23.ADDRESS);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "5"), Data.Testcase_23.ADDRESS2);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "6"), Data.Testcase_23.CITY + " " + Data.Testcase_23.STATE + " " + Data.Testcase_23.ZIPCODE);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "7"), Data.Testcase_23.COUNTRY);
		verifyEquals(checkoutPage.getBillingAddressValue(driver, "8"), Data.Testcase_23.MOBILENUMBER);
		
		log.info("Testcase_23 - Step 11: Click 'Delete Account' button");
		checkoutPage.openMenuPage(driver, "Delete Account");
		deleteAccountPage = PageGenerator.getDeleteAccountPage(driver);
		
		log.info("Testcase_23 - Step 12: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
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
