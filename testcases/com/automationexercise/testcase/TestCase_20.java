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
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_20 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	SignupLoginPageObject signupLoginPage;
	SignupPageObject signupPage;
	ProductsPageObject productsPage;
	CartPageObject cartPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 20: Search Products and Verify Cart After Login")
	public void Testcase_20() {
		log.info("Testcase_20 - Step 01: Click on 'Products' button");
		homePage.openMenuPage(driver, "Products");
		productsPage = PageGenerator.getProductsPage(driver);
		
		log.info("Testcase_20 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		verifyTrue(productsPage.isTitleTextDisplayed(driver, "All Products"));
		
		log.info("Testcase_20 - Step 03: Enter product name in search input and click search button");
		productsPage.enterToTextboxByIDName(driver, "search_product", Data.Testcase_09.SEARCH_TEXT);
		productsPage.clickToButtonByIDName(driver, "submit_search");
		
		log.info("Testcase_20 - Step 04: Verify 'SEARCHED PRODUCTS' is visible");
		verifyTrue(productsPage.isTitleTextDisplayed(driver, "SEARCHED PRODUCTS"));
		
		log.info("Testcase_20 - Step 05: Verify all the products related to search are visible");
		verifyTrue(productsPage.isSearchedProductsDisplayed(driver, "1"));
		
		log.info("Testcase_20 - Step 06: Add those products to cart");
		String product_name = productsPage.getProductNameInList(driver, "1");
		productsPage.addProductToCartInProductLists(driver, "1");
		
		log.info("Testcase_20 - Step 07: Click 'Cart' button and verify that products are visible in cart");
		productsPage.getWindowHanle(driver);
		productsPage.clickToButtonByTitle(driver, "Continue Shopping");
		productsPage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_20 - Step 08: Click 'Signup / Login' button and submit login details");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		signupLoginPage.enterToTextboxByDataQA(driver, "login-email", Data.Testcase_01.USER_NAME);
		signupLoginPage.enterToTextboxByDataQA(driver, "login-password", Data.Testcase_01.PASSWORD);
		signupLoginPage.clickToButtonByDataQA(driver, "login-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_20 - Step 09: Again, go to Cart page");
		homePage.openMenuPage(driver, "Cart");
		cartPage = PageGenerator.getCartPage(driver);
		
		log.info("Testcase_20 - Step 10: Verify that those products are visible in cart after login as well");
		verifyEquals(cartPage.getProductLinkInCart("1", "cart_description"), product_name);
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
