package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationexercise.data.Data;

import commons.BaseTest;
import pageObjects.automationexercise.ContactUsPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.PageGenerator;

public class TestCase_06 extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ContactUsPageObject contactUsPage;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 6: Contact Us Form")
	public void Testcase_06() {
		log.info("Testcase_06 - Step 01: Click on 'Contact Us' button");
		homePage.openMenuPage(driver, "Contact us");
		contactUsPage = PageGenerator.getContactUsPage(driver);
		
		log.info("Testcase_06 - Step 02: Verify 'GET IN TOUCH' is visible");
		verifyTrue(contactUsPage.isTitleTextDisplayed(driver, "GET IN TOUCH"));
		
		log.info("Testcase_06 - Step 03: Enter name, email, subject and message");
		contactUsPage.enterToTextboxByDataQA(driver, "name", Data.Testcase_01.USER_NAME);
		contactUsPage.enterToTextboxByDataQA(driver, "email", Data.Testcase_01.EMAIL);
		contactUsPage.enterToTextboxByDataQA(driver, "subject", Data.Testcase_06.SUBJECT);
		contactUsPage.enterToTextareaByIDName(driver, "message", Data.Testcase_06.MESSAGE);
		
		log.info("Testcase_06 - Step 04: Upload file");
		contactUsPage.uploadImage(driver,  Data.Testcase_06.IMAGE_PATH);
		
		log.info("Testcase_06 - Step 05: Click 'Submit' button");
		contactUsPage.clickToButtonByDataQA(driver, "submit-button");
		
		log.info("Testcase_06 - Step 06: Click OK button");
		contactUsPage.acceptAlert(driver);
		
		log.info("Testcase_06 - Step 07: Verify success message 'Success! Your details have been submitted successfully.' is visible");
		verifyTrue(contactUsPage.isTitleTextDisplayed(driver, "Success! Your details have been submitted successfully."));
		
		log.info("Testcase_06 - Step 08: Click 'Home' button and verify that landed to home page successfully");
		contactUsPage.clickToHomeButton();
		homePage = PageGenerator.getHomePage(driver);
		verifyTrue(homePage.isTitleTextDisplayed("Full-Fledged practice website for Automation Engineers"));
	}
	
	@Parameters({ "browserName" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
