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

public class TestCase_03 extends BaseTest {
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
	
	@Test(description = "Test Case 3: Login User with incorrect email and password")
	public void Testcase_03() {
		log.info("Testcase_03 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_03 - Step 02: Verify 'Login to your account' is visible");
		verifyTrue(signupLoginPage.isTitleTextDisplayed(driver, "Login to your account"));
		
		log.info("Testcase_03 - Step 03: Enter incorrect email address and password");
		signupLoginPage.enterToTextboxByDataQA(driver, "login-email", Data.Testcase_01.USER_NAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "login-password", Data.Testcase_01.PASSWORD + 0000);
		
		log.info("Testcase_03 - Step 04: Click 'login' button");
		signupLoginPage.clickToButtonByDataQA(driver, "login-button");
		
		log.info("Testcase_03 - Step 05: Verify error 'Your email or password is incorrect!' is visible");
		verifyTrue(signupLoginPage.isTitleTextDisplayed(driver, "Your email or password is incorrect!"));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
