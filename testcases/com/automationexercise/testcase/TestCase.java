package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.LoginPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.RegisterPageObject;

public class TestCase extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	LoginPageObject loginPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 1: Register User")
	public void Testcase_01() {
		log.info("");
	}
	
	@Test(description = "Test Case 2: Login User with correct email and password")
	public void Testcase_02() {
		
	}
	
	@Test(description = "Test Case 3: Login User with incorrect email and password")
	public void Testcase_03() {
		
	}
	
	@Test(description = "Test Case 4: Logout User")
	public void Testcase_04() {
		
	}
	
	@Test(description = "Test Case 5: Register User with existing email")
	public void Testcase_05() {
		
	}
	
	@Test(description = "Test Case 6: Contact Us Form")
	public void Testcase_06() {
		
	}
	
	@Test(description = "Test Case 7: Verify Test Cases Page")
	public void Testcase_07() {
		
	}
	
	@Test(description = "Test Case 8: Verify All Products and product detail page")
	public void Testcase_08() {
		
	}
	
	@Test(description = "Test Case 9: Search Product")
	public void Testcase_09() {
		
	}
	
	@Test(description = "Test Case 10: Verify Subscription in home page")
	public void Testcase_10() {
		
	}
	
	@Test(description = "Test Case 11: Verify Subscription in Cart page")
	public void Testcase_11() {
		
	}
	
	@Test(description = "Test Case 12: Add Products in Cart")
	public void Testcase_12() {
		
	}
	
	@Test(description = "Test Case 13: Verify Product quantity in Cart")
	public void Testcase_13() {
		
	}
	
	@Test(description = "Test Case 14: Place Order: Register while Checkout")
	public void Testcase_14() {
		
	}
	
	@Test(description = "Test Case 15: Place Order: Register before Checkout")
	public void Testcase_15() {
		
	}
	
	@Test(description = "Test Case 16: Place Order: Login before Checkout")
	public void Testcase_16() {
		
	}
	
	@Test(description = "Test Case 17: Remove Products From Cart")
	public void Testcase_17() {
		
	}
	
	@Test(description = "Test Case 18: View Category Products")
	public void Testcase_18() {
		
	}
	
	@Test(description = "Test Case 19: View & Cart Brand Products")
	public void Testcase_19() {
		
	}
	
	@Test(description = "Test Case 20: Search Products and Verify Cart After Login")
	public void Testcase_20() {
		
	}
	
	@Test(description = "Test Case 21: Add review on product")
	public void Testcase_21() {
		
	}
	
	@Test(description = "Test Case 22: Add to cart from Recommended items")
	public void Testcase_22() {
		
	}
	
	@Test(description = "Test Case 23: Verify address details in checkout page")
	public void Testcase_23() {
		
	}
	
	@Test(description = "Test Case 24: Download Invoice after purchase order")
	public void Testcase_24() {
		
	}
	
	@Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
	public void Testcase_25() {
		
	}
	
	@Test(description = "Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
	public void Testcase_26() {
		
	}
	
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
