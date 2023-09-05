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
import pageObjects.automationexercise.ProductsDetailPageObject;
import pageObjects.automationexercise.ProductsPageObject;

public class TestCase_21 extends BaseTest {
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
	
	@Test(description = "Test Case 21: Add review on product")
	public void Testcase_21() {
		log.info("Testcase_21 - Step 01: Click on 'Products' button");
		homePage.openMenuPage(driver, "Products");
		productsPage = PageGenerator.getProductsPage(driver);
		
		log.info("Testcase_21 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		verifyTrue(productsPage.isTitleTextDisplayed(driver, "ALL PRODUCTS"));
		
		log.info("Testcase_21 - Step 03: Click on 'View Product' button");
		productsPage.clickToViewProduct(driver, "1");
		productsDetailPage = PageGenerator.getProductsDetailPage(driver);
		
		log.info("Testcase_21 - Step 04: Verify 'Write Your Review' is visible");
		verifyTrue(productsDetailPage.isTitleTextDisplayed(driver, "WRITE YOUR REVIEW"));
		
		log.info("Testcase_21 - Step 05: Enter name, email and review");
		productsDetailPage.enterToTextboxByIDName(driver, "name", Data.Testcase_01.USERNAME);
		productsDetailPage.enterToTextboxByIDName(driver, "email", Data.Testcase_01.EMAIL);
		productsDetailPage.enterToTextboxByIDName(driver, "review", Data.Testcase_21.REVIEW);
		
		log.info("Testcase_21 - Step 06: Click 'Submit' button");
		productsDetailPage.clickToButtonByIDName(driver, "button-review");
		
		log.info("Testcase_21 - Step 07: Verify success message 'Thank you for your review.'");
		verifyTrue(productsDetailPage.isTitleTextDisplayed(driver, "Thank you for your review."));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
