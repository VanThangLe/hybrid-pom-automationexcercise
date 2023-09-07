package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.CartPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;

public class TestCase_17 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 17: Remove Products From Cart")
	public void Testcase_17() {
		log.info("Testcase_17 - Step 01: Add products to cart");
		homePage.addProductToCartInProductLists(driver, "1");
		
		log.info("Testcase_17 - Step 02: Click 'Cart' button");
		homePage.getWindowHanle(driver);
		homePage.clickToButtonByTitle(driver, "Continue Shopping");
		homePage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_17 - Step 03: Verify that cart page is displayed");
		verifyTrue(cartPage.isTitleTextDisplayed(driver, "Shopping Cart"));
		
		log.info("Testcase_17 - Step 04: Click 'X' button corresponding to particular product");
		cartPage.clickToDeleteProductOutOfCart("1", "cart_delete");
		
		log.info("Testcase_17 - Step 05: Verify that product is removed from the cart");
		verifyTrue(cartPage.isTitleTextDisplayed(driver, "Cart is empty!"));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
