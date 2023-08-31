package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationexercise.data.Data;

import commons.BaseTest;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;

public class TestCase_10 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 10: Verify Subscription in home page")
	public void Testcase_10() {
		log.info("Testcase_10 - Step 01: Scroll down to footer");
		homePage.scrollToBottomPage(driver);
		
		log.info("Testcase_10 - Step 02: Verify text 'SUBSCRIPTION' displayed");
		verifyTrue(homePage.isLabelFormDisplayed(driver, "Subscription"));
		
		log.info("Testcase_10 - Step 03: Enter email address in input and click arrow button");
		homePage.enterToTextboxByDataQA(driver, "susbscribe_email", Data.Testcase_01.EMAIL);
		homePage.clickToButtonByIDName(driver, "subscribe");
		
		log.info("Testcase_10 - Step 04: Verify success message 'You have been successfully subscribed!' is visible");
		verifyTrue(homePage.isLabelFormDisplayed(driver, "You have been successfully subscribed!"));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
