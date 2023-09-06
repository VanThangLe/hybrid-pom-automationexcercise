package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.ProductsDetailPageObject;
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_12 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductsPageObject productsPage;
	ProductsDetailPageObject productsDetailPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 12: Add Products in Cart")
	public void Testcase_12() {
		log.info("Testcase_12 - Step 01: Click 'Products' button");
		homePage.openMenuPage(driver, "Products");
		productsPage = PageGenerator.getProductsPage(driver);
		
		log.info("Testcase_12 - Step 02: Hover over first product and click 'Add to cart'");
		productsPage.addProductToCartInProductLists(driver, "1");
		
		log.info("Testcase_12 - Step 03: Click 'Continue Shopping' button");
		productsPage.clickToButtonByTitle(driver, "Continue Shopping");
		
		log.info("Testcase_12 - Step 04: Hover over second product and click 'Add to cart'");
		productsPage.addProductToCartInProductLists(driver, "2");
		
		log.info("Testcase_12 - Step 05: Click 'View Cart' button");
		productsPage.clickToButtonByTitle(driver, "View Cart");
		
		log.info("Testcase_12 - Step 06: Verify both products are added to Cart");
		
		
		log.info("Testcase_12 - Step 07: Verify their prices, quantity and total price");
		
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
