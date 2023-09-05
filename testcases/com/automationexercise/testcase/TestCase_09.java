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
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_09 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductsPageObject productsPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 9: Search Product")
	public void Testcase_09() {
		log.info("Testcase_09 - Step 01: Click on 'Products' button");
		homePage.openMenuPage(driver, "Products");
		productsPage = PageGenerator.getProductsPage(driver);
		
		log.info("Testcase_09 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		verifyTrue(productsPage.isTitleTextDisplayed(driver, "ALL PRODUCTS"));
		
		log.info("Testcase_09 - Step 03: Enter product name in search input and click search button");
		productsPage.enterToTextboxByIDName(driver, "search_product", Data.Testcase_09.SEARCHTEXT);
		productsPage.clickToButtonByIDName(driver, "submit_search");
		
		log.info("Testcase_09 - Step 04: Verify 'SEARCHED PRODUCTS' is visible");
		verifyTrue(productsPage.isTitleTextDisplayed(driver, "SEARCHED PRODUCTS"));
		
		log.info("Testcase_09 - Step 05: Verify all the products related to search are visible");
		verifyTrue(productsPage.isSearchedProductsDisplayed(driver, "1"));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
