package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationexercise.data.Data;

import commons.BaseTest;
import pageObjects.automationexercise.AccountCreatedPageObject;
import pageObjects.automationexercise.DeleteAccountPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.RegisterPageObject;

public class TestCase_01 extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	SignupLoginPageObject signupLoginPage;
	SignupPageObject signupPage;
	AccountCreatedPageObject accountCreatedPage;
	DeleteAccountPageObject deleteAccountPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 1: Register User")
	public void Testcase_01() {
		log.info("Testcase_01 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_01 - Step 02: Verify 'New User Signup!' is visible");
		verifyTrue(signupLoginPage.isTitleTextDisplayed(driver, "New User Signup!"));
		
		log.info("Testcase_01 - Step 03: Enter name and email address");
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-name", Data.Testcase_01.USER_NAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-email", Data.Testcase_01.EMAIL);
		
		log.info("Testcase_01 - Step 04: Click 'Signup' button");
		signupLoginPage.clickToButtonByDataQA(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		log.info("Testcase_01 - Step 05: Verify that 'ENTER ACCOUNT INFORMATION' is visible");
		verifyTrue(signupPage.isTitleTextDisplayed(driver, "Enter Account Information"));
		
		log.info("Testcase_01 - Step 06: Fill details: Title, Name, Email, Password, Date of birth");
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByDataQA(driver, "name", Data.Testcase_01.USER_NAME);
		signupPage.enterToTextboxByDataQA(driver, "password", Data.Testcase_01.PASSWORD);
		signupPage.selectItemInDropdownByName(driver, "days", Data.Testcase_01.DAY);
		signupPage.selectItemInDropdownByName(driver, "months", Data.Testcase_01.MONTH);
		signupPage.selectItemInDropdownByName(driver, "years", Data.Testcase_01.YEAR);
		
		log.info("Testcase_01 - Step 07: Select checkbox 'Sign up for our newsletter!'");
		signupPage.clickToCheckboxByID(driver, "newsletter");
		
		log.info("Testcase_01 - Step 08: Select checkbox 'Receive special offers from our partners!'");
		signupPage.clickToCheckboxByID(driver, "optin");
		
		log.info("Testcase_01 - Step 09: Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
		signupPage.enterToTextboxByDataQA(driver, "first_name", Data.Testcase_01.FIRST_NAME);
		signupPage.enterToTextboxByDataQA(driver, "last_name", Data.Testcase_01.LAST_NAME);
		signupPage.enterToTextboxByDataQA(driver, "company", Data.Testcase_01.COMPANY);
		signupPage.enterToTextboxByDataQA(driver, "address", Data.Testcase_01.ADDRESS);
		signupPage.enterToTextboxByDataQA(driver, "address2", Data.Testcase_01.ADDRESS2);
		signupPage.selectItemInDropdownByName(driver, "country", Data.Testcase_01.COUNTRY);
		signupPage.enterToTextboxByDataQA(driver, "state", Data.Testcase_01.STATE);
		signupPage.enterToTextboxByDataQA(driver, "city", Data.Testcase_01.CITY);
		signupPage.enterToTextboxByDataQA(driver, "zipcode", Data.Testcase_01.ZIPCODE);
		signupPage.enterToTextboxByDataQA(driver, "mobile_number", Data.Testcase_01.MOBILE_NUMBER);
		
		log.info("Testcase_01 - Step 10: Click 'Create Account button'");
		signupPage.clickToButtonByDataQA(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		log.info("Testcase_01 - Step 11: Verify that 'ACCOUNT CREATED!' is visible");
		verifyTrue(accountCreatedPage.isTitleTextDisplayed(driver, "ACCOUNT CREATED!"));
		
		log.info("Testcase_01 - Step 12: Click 'Continue' button");
		accountCreatedPage.clickToButtonByDataQA(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_01 - Step 13: Verify that 'Logged in as username' is visible");
		verifyTrue(homePage.isTitleTextDisplayed(driver, "Logged in as " + Data.Testcase_01.USER_NAME));
		
		log.info("Testcase_01 - Step 14: Click 'Delete Account' button");
		homePage.openMenuPage(driver, "Delete Account");
		deleteAccountPage = PageGenerator.getDeleteAccountPage(driver);
		
		log.info("Testcase_01 - Step 15: Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
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
