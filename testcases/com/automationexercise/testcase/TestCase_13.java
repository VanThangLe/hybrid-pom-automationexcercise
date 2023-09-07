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
import pageObjects.automationexercise.ProductsDetailPageObject;
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_13 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductsPageObject productsPage;
	ProductsDetailPageObject productsDetailPage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 13: Verify Product quantity in Cart")
	public void Testcase_13() {
		log.info("Testcase_13 - Step 01: Click 'View Product' for any product on home page");
		homePage.clickToViewProduct(driver, "1");
		productsDetailPage = PageGenerator.getProductsDetailPage(driver);
		
		log.info("Testcase_13 - Step 02: Verify product detail is opened");
		verifyTrue(productsDetailPage.isTitleTextDisplayed(driver, "WRITE YOUR REVIEW"));
		
		log.info("Testcase_13 - Step 03: Increase quantity to 4");
		productsDetailPage.enterToTextboxByIDName(driver, "quantity", Data.Testcase_13.QUANTITY);
		
		log.info("Testcase_13 - Step 04: Click 'Add to cart' button");
		productsDetailPage.clickToButtonByTitle(driver, "Add to cart");
		
		log.info("Testcase_13 - Step 05: Click 'View Cart' button");
		productsDetailPage.getWindowHanle(driver);
		productsDetailPage.clickToButtonByTitle(driver, "View Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_13 - Step 06: Verify that product is displayed in cart page with exact quantity");
		verifyEquals(cartPage.getProductQuantityInCart("1"), Data.Testcase_13.QUANTITY);
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
