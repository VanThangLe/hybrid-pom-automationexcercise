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

public class TestCase_05 extends BaseTest {
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
	
	@Test(description = "Test Case 5: Register User with existing email")
	public void Testcase_05() {
		log.info("Testcase_05 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_05 - Step 02: Verify 'New User Signup!' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "New User Signup!"));
		
		log.info("Testcase_05 - Step 03: Enter name and already registered email address");
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-name", Data.Testcase_01.USERNAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "signup-email", Data.Testcase_01.EMAIL);
		
		log.info("Testcase_05 - Step 04: Click 'Signup' button");
		signupLoginPage.clickToButtonByDataQA(driver, "signup-button");
		
		log.info("Testcase_05 - Step 05: Verify error 'Email Address already exist!' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "Email Address already exist!"));
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
