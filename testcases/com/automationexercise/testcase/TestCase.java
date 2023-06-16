package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.AccountCreatedPageObject;
import pageObjects.automationexercise.DeleteAccountPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.RegisterPageObject;

public class TestCase extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	SignupLoginPageObject signupLoginPage;
	SignupPageObject signupPage;
	AccountCreatedPageObject accountCreatedPage;
	DeleteAccountPageObject deleteAccountPage;
	
	String username, email, password, day, month, year, last_name, first_name, company, address, address2, country, state, city, zipcode, mobile_number;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
		
		username = "Automation FC";
		email = "automation@gmail.com";
		password = "12345678";
		day = "1";
		month = "January";
		year = "2001";
		last_name = "Automation";
		first_name = "FC";
		company = "Automation FC";
		address = "New York";
		address2 = "Washington, D.C.";
		country = "United States";
		state = "New York";
		city = "New York";
		zipcode = "100000";
		mobile_number = "369258147";
	}
	
	@Test(description = "Test Case 1: Register User")
	public void Testcase_01() {
		log.info("Testcase_01 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_01 - Step 02: Verify 'New User Signup!' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "New User Signup!"));
		
		log.info("Testcase_01 - Step 03: Enter name and email address");
		signupLoginPage.enterToTextboxByIDName(driver, "signup-name", username);
		signupLoginPage.enterToTextboxByIDName(driver, "signup-email", email);
		
		log.info("Testcase_01 - Step 04: Click 'Signup' button");
		signupLoginPage.clickToButtonByLabel(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		log.info("Testcase_01 - Step 05: Verify that 'ENTER ACCOUNT INFORMATION' is visible");
		verifyTrue(signupPage.isLabelFormDisplayed(driver, "Enter Account Information"));
		
		log.info("Testcase_01 - Step 06: Fill details: Title, Name, Email, Password, Date of birth");
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByIDName(driver, "name", username);
		signupPage.enterToTextboxByIDName(driver, "password", password);
		signupPage.selectItemInDropdownByName(driver, "days", day);
		signupPage.selectItemInDropdownByName(driver, "months", month);
		signupPage.selectItemInDropdownByName(driver, "years", year);
		
		log.info("Testcase_01 - Step 07: Select checkbox 'Sign up for our newsletter!'");
		signupPage.clickToCheckboxByID(driver, "newsletter");
		
		log.info("Testcase_01 - Step 08: Select checkbox 'Receive special offers from our partners!'");
		signupPage.clickToCheckboxByID(driver, "optin");
		
		log.info("Testcase_01 - Step 09: Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
		signupPage.enterToTextboxByIDName(driver, "first_name", last_name);
		signupPage.enterToTextboxByIDName(driver, "last_name", first_name);
		signupPage.enterToTextboxByIDName(driver, "company", company);
		signupPage.enterToTextboxByIDName(driver, "address", address);
		signupPage.enterToTextboxByIDName(driver, "address2", address2);
		signupPage.selectItemInDropdownByName(driver, "country", country);
		signupPage.enterToTextboxByIDName(driver, "state", state);
		signupPage.enterToTextboxByIDName(driver, "city", city);
		signupPage.enterToTextboxByIDName(driver, "zipcode", zipcode);
		signupPage.enterToTextboxByIDName(driver, "mobile_number", mobile_number);
		
		log.info("Testcase_01 - Step 10: Click 'Create Account button'");
		signupPage.clickToButtonByLabel(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		log.info("Testcase_01 - Step 11: Verify that 'ACCOUNT CREATED!' is visible");
		verifyTrue(accountCreatedPage.isLabelFormDisplayed(driver, "ACCOUNT CREATED!"));
		
		log.info("Testcase_01 - Step 12: Click 'Continue' button");
		accountCreatedPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_01 - Step 13: Verify that 'Logged in as username' is visible");
		verifyTrue(homePage.isLabelFormDisplayed(driver, "Logged in as " + username));
		
		log.info("Testcase_01 - Step 14: Click 'Delete Account' button");
		homePage.openMenuPage(driver, "Delete Account");
		deleteAccountPage = PageGenerator.getDeleteAccountPage(driver);
		
		log.info("Testcase_01 - Step 15: Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
		verifyTrue(deleteAccountPage.isLabelFormDisplayed(driver, "ACCOUNT DELETED!"));
		deleteAccountPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 2: Login User with correct email and password")
	public void Testcase_02() {
		
	}
	
	@Test(description = "Test Case 3: Login User with incorrect email and password")
	public void Testcase_03() {
		
	}
	
	@Test(description = "Test Case 4: Logout User")
	public void Testcase_04() {
		
	}
	
	@Test(description = "Test Case 5: Register User with existing email")
	public void Testcase_05() {
		
	}
	
	@Test(description = "Test Case 6: Contact Us Form")
	public void Testcase_06() {
		
	}
	
	@Test(description = "Test Case 7: Verify Test Cases Page")
	public void Testcase_07() {
		
	}
	
	@Test(description = "Test Case 8: Verify All Products and product detail page")
	public void Testcase_08() {
		
	}
	
	@Test(description = "Test Case 9: Search Product")
	public void Testcase_09() {
		
	}
	
	@Test(description = "Test Case 10: Verify Subscription in home page")
	public void Testcase_10() {
		
	}
	
	@Test(description = "Test Case 11: Verify Subscription in Cart page")
	public void Testcase_11() {
		
	}
	
	@Test(description = "Test Case 12: Add Products in Cart")
	public void Testcase_12() {
		
	}
	
	@Test(description = "Test Case 13: Verify Product quantity in Cart")
	public void Testcase_13() {
		
	}
	
	@Test(description = "Test Case 14: Place Order: Register while Checkout")
	public void Testcase_14() {
		
	}
	
	@Test(description = "Test Case 15: Place Order: Register before Checkout")
	public void Testcase_15() {
		
	}
	
	@Test(description = "Test Case 16: Place Order: Login before Checkout")
	public void Testcase_16() {
		
	}
	
	@Test(description = "Test Case 17: Remove Products From Cart")
	public void Testcase_17() {
		
	}
	
	@Test(description = "Test Case 18: View Category Products")
	public void Testcase_18() {
		
	}
	
	@Test(description = "Test Case 19: View & Cart Brand Products")
	public void Testcase_19() {
		
	}
	
	@Test(description = "Test Case 20: Search Products and Verify Cart After Login")
	public void Testcase_20() {
		
	}
	
	@Test(description = "Test Case 21: Add review on product")
	public void Testcase_21() {
		
	}
	
	@Test(description = "Test Case 22: Add to cart from Recommended items")
	public void Testcase_22() {
		
	}
	
	@Test(description = "Test Case 23: Verify address details in checkout page")
	public void Testcase_23() {
		
	}
	
	@Test(description = "Test Case 24: Download Invoice after purchase order")
	public void Testcase_24() {
		
	}
	
	@Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
	public void Testcase_25() {
		
	}
	
	@Test(description = "Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
	public void Testcase_26() {
		
	}
	
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
