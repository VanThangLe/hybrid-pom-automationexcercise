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

public class TestCase_08 extends BaseTest {
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
	
	@Test(description = "Test Case 8: Verify All Products and product detail page")
	public void Testcase_08() {
		log.info("Testcase_08 - Step 01: Click on 'Products' button");
		homePage.openMenuPage(driver, "Products");
		productsPage = PageGenerator.getProductsPage(driver);
		
		log.info("Testcase_08 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		verifyTrue(productsPage.isTitleTextDisplayed(driver, "ALL PRODUCTS"));
		
		log.info("Testcase_08 - Step 03: The products list is visible");
		productsPage.isProductsVisible();
		
		log.info("Testcase_08 - Step 04: Click on 'View Product' of first product");
		productsPage.clickToViewProduct(driver, "1");
		
		log.info("Testcase_08 - Step 05: User is landed to product detail page");
		productsDetailPage = PageGenerator.getProductsDetailPage(driver);
		
		log.info("Testcase_08 - Step 06: Verify that detail is visible: product name, category, price, availability, condition, brand");
		verifyTrue(productsDetailPage.isProductsNameVisible());
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("1"));
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("2"));
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("3"));
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("4"));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
