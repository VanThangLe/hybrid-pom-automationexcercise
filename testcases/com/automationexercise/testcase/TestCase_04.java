package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationexercise.data.Data;

import commons.BaseTest;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.PageGenerator;

public class TestCase_04 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	SignupLoginPageObject signupLoginPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 4: Logout User")
	public void Testcase_04() {
		log.info("Testcase_04 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_04 - Step 02: Verify 'Login to your account' is visible");
		verifyTrue(signupLoginPage.isTitleTextDisplayed(driver, "Login to your account"));
		
		log.info("Testcase_04 - Step 03: Enter correct email address and password");
		signupLoginPage.enterToTextboxByDataQA(driver, "login-email", Data.Testcase_01.USER_NAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "login-password", Data.Testcase_01.PASSWORD);
		
		log.info("Testcase_04 - Step 04: Click 'login' button");
		signupLoginPage.clickToButtonByDataQA(driver, "login-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_04 - Step 05: Verify that 'Logged in as username' is visible");
		verifyTrue(homePage.isTitleTextDisplayed(driver, "Logged in as " + Data.Testcase_01.USER_NAME));
		
		log.info("Testcase_04 - Step 06: Click 'Logout' button");
		homePage.openMenuPage(driver, "Logout");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_04 - Step 07: Verify that user is navigated to login page");
		verifyTrue(signupLoginPage.isTitleTextDisplayed(driver, "Login to your account"));
		signupLoginPage.openMenuPage(driver, "Home");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
