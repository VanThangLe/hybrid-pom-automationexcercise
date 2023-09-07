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
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_12 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductsPageObject productsPage;
	CartPageObject cartPage;
	
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
		String product_1_name = productsPage.getProductNameInList(driver, "1");
		String product_1_price = productsPage.getProductPriceInList(driver, "1");
		productsPage.addProductToCartInProductLists(driver, "1");
		
		log.info("Testcase_12 - Step 03: Click 'Continue Shopping' button");
		productsPage.getWindowHanle(driver);
		productsPage.clickToButtonByTitle(driver, "Continue Shopping");
		
		log.info("Testcase_12 - Step 04: Hover over second product and click 'Add to cart'");
		String product_2_name = productsPage.getProductNameInList(driver, "2");
		String product_2_price = productsPage.getProductPriceInList(driver, "2");
		productsPage.addProductToCartInProductLists(driver, "2");
		
		log.info("Testcase_12 - Step 05: Click 'View Cart' button");
		productsPage.getWindowHanle(driver);
		productsPage.clickToButtonByTitle(driver, "View Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_12 - Step 06: Verify both products are added to Cart");
		verifyEquals(cartPage.getProductLinkInCart("1", "cart_description"), product_1_name);
		verifyEquals(cartPage.getProductLinkInCart("2", "cart_description"), product_2_name);
		
		log.info("Testcase_12 - Step 07: Verify their prices, quantity and total price");
		verifyEquals(cartPage.getProductPriceInCart("1", "cart_price"), product_1_price);
		verifyEquals(cartPage.getProductQuantityInCart("1"), "1");
		verifyEquals(cartPage.getProductPriceInCart("1", "cart_total"), product_1_price);
		verifyEquals(cartPage.getProductPriceInCart("2", "cart_price"), product_2_price);
		verifyEquals(cartPage.getProductQuantityInCart("2"), "1");
		verifyEquals(cartPage.getProductPriceInCart("2", "cart_total"), product_2_price);
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
