package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationexercise.data.Data;

import commons.BaseTest;
import pageObjects.automationexercise.CartPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.RegisterPageObject;

public class TestCase_11 extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 11: Verify Subscription in Cart page")
	public void Testcase_11() {
		log.info("Testcase_11 - Step 01: Click 'Cart' button");
		homePage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_11 - Step 02: Scroll down to footer");
		cartPage.scrollToBottomPage(driver);
		
		log.info("Testcase_11 - Step 03: Verify text 'SUBSCRIPTION' displayed");
		verifyTrue(cartPage.isLabelFormDisplayed(driver, "Subscription"));
		
		log.info("Testcase_11 - Step 04: Enter email address in input and click arrow button");
		cartPage.enterToTextboxByDataQA(driver, "susbscribe_email", Data.Testcase_01.EMAIL);
		cartPage.clickToButtonByIDName(driver, "subscribe");
		
		log.info("Testcase_11 - Step 05: Verify success message 'You have been successfully subscribed!' is visible");
		verifyTrue(cartPage.isLabelFormDisplayed(driver, "You have been successfully subscribed!"));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
