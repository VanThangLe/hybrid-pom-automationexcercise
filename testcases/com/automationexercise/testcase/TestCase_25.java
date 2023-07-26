package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.automationexercise.AccountCreatedPageObject;
import pageObjects.automationexercise.ContactUsPageObject;
import pageObjects.automationexercise.DeleteAccountPageObject;
import pageObjects.automationexercise.HomePageObject;
import pageObjects.automationexercise.SignupLoginPageObject;
import pageObjects.automationexercise.SignupPageObject;
import pageObjects.automationexercise.TestCasesPageObject;
import pageObjects.automationexercise.PageGenerator;
import pageObjects.automationexercise.ProductsDetailPageObject;
import pageObjects.automationexercise.ProductsPageObject;
import pageObjects.automationexercise.RegisterPageObject;

public class TestCase_25 extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	SignupLoginPageObject signupLoginPage;
	SignupPageObject signupPage;
	AccountCreatedPageObject accountCreatedPage;
	DeleteAccountPageObject deleteAccountPage;
	ContactUsPageObject contactUsPage;
	TestCasesPageObject testCasesPage;
	ProductsPageObject productsPage;
	ProductsDetailPageObject productsDetailPage;
	
	String username, email, password, day, month, year, last_name, first_name, company, address, address2, country, state, city, zipcode, mobile_number;
	String imagePath = GlobalConstants.UPLOAD_FOLDER_PATH + "a.jpg";
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeClass
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
		
		username = "Automation FC";
		email = "automation@gmail.com";
		password = "12345678";
		day = "1";
		month = "January";
		year = "2001";
		last_name = "Automation";
		first_name = "FC";
		company = "Automation FC";
		address = "New York";
		address2 = "Washington, D.C.";
		country = "United States";
		state = "New York";
		city = "New York";
		zipcode = "100000";
		mobile_number = "369258147";
	}
	
	@Test(description = "Test Case 1: Register User")
	public void Testcase_01() {
		log.info("Testcase_01 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_01 - Step 02: Verify 'New User Signup!' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "New User Signup!"));
		
		log.info("Testcase_01 - Step 03: Enter name and email address");
		signupLoginPage.enterToTextboxByIDName(driver, "signup-name", username);
		signupLoginPage.enterToTextboxByIDName(driver, "signup-email", email);
		
		log.info("Testcase_01 - Step 04: Click 'Signup' button");
		signupLoginPage.clickToButtonByLabel(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		log.info("Testcase_01 - Step 05: Verify that 'ENTER ACCOUNT INFORMATION' is visible");
		verifyTrue(signupPage.isLabelFormDisplayed(driver, "Enter Account Information"));
		
		log.info("Testcase_01 - Step 06: Fill details: Title, Name, Email, Password, Date of birth");
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByIDName(driver, "name", username);
		signupPage.enterToTextboxByIDName(driver, "password", password);
		signupPage.selectItemInDropdownByName(driver, "days", day);
		signupPage.selectItemInDropdownByName(driver, "months", month);
		signupPage.selectItemInDropdownByName(driver, "years", year);
		
		log.info("Testcase_01 - Step 07: Select checkbox 'Sign up for our newsletter!'");
		signupPage.clickToCheckboxByID(driver, "newsletter");
		
		log.info("Testcase_01 - Step 08: Select checkbox 'Receive special offers from our partners!'");
		signupPage.clickToCheckboxByID(driver, "optin");
		
		log.info("Testcase_01 - Step 09: Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
		signupPage.enterToTextboxByIDName(driver, "first_name", last_name);
		signupPage.enterToTextboxByIDName(driver, "last_name", first_name);
		signupPage.enterToTextboxByIDName(driver, "company", company);
		signupPage.enterToTextboxByIDName(driver, "address", address);
		signupPage.enterToTextboxByIDName(driver, "address2", address2);
		signupPage.selectItemInDropdownByName(driver, "country", country);
		signupPage.enterToTextboxByIDName(driver, "state", state);
		signupPage.enterToTextboxByIDName(driver, "city", city);
		signupPage.enterToTextboxByIDName(driver, "zipcode", zipcode);
		signupPage.enterToTextboxByIDName(driver, "mobile_number", mobile_number);
		
		log.info("Testcase_01 - Step 10: Click 'Create Account button'");
		signupPage.clickToButtonByLabel(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		log.info("Testcase_01 - Step 11: Verify that 'ACCOUNT CREATED!' is visible");
		verifyTrue(accountCreatedPage.isLabelFormDisplayed(driver, "ACCOUNT CREATED!"));
		
		log.info("Testcase_01 - Step 12: Click 'Continue' button");
		accountCreatedPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_01 - Step 13: Verify that 'Logged in as username' is visible");
		verifyTrue(homePage.isLabelFormDisplayed(driver, "Logged in as " + username));
		
		log.info("Testcase_01 - Step 14: Click 'Delete Account' button");
		homePage.openMenuPage(driver, "Delete Account");
		deleteAccountPage = PageGenerator.getDeleteAccountPage(driver);
		
		log.info("Testcase_01 - Step 15: Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
		verifyTrue(deleteAccountPage.isLabelFormDisplayed(driver, "ACCOUNT DELETED!"));
		deleteAccountPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 2: Login User with correct email and password")
	public void Testcase_02() {
		log.info("Testcase_02 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_02 - Step 02: Create new account");
		signupLoginPage.enterToTextboxByIDName(driver, "signup-name", username);
		signupLoginPage.enterToTextboxByIDName(driver, "signup-email", email);
		signupLoginPage.clickToButtonByLabel(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByIDName(driver, "name", username);
		signupPage.enterToTextboxByIDName(driver, "password", password);
		signupPage.selectItemInDropdownByName(driver, "days", day);
		signupPage.selectItemInDropdownByName(driver, "months", month);
		signupPage.selectItemInDropdownByName(driver, "years", year);
		signupPage.clickToCheckboxByID(driver, "newsletter");
		signupPage.clickToCheckboxByID(driver, "optin");
		signupPage.enterToTextboxByIDName(driver, "first_name", last_name);
		signupPage.enterToTextboxByIDName(driver, "last_name", first_name);
		signupPage.enterToTextboxByIDName(driver, "company", company);
		signupPage.enterToTextboxByIDName(driver, "address", address);
		signupPage.enterToTextboxByIDName(driver, "address2", address2);
		signupPage.selectItemInDropdownByName(driver, "country", country);
		signupPage.enterToTextboxByIDName(driver, "state", state);
		signupPage.enterToTextboxByIDName(driver, "city", city);
		signupPage.enterToTextboxByIDName(driver, "zipcode", zipcode);
		signupPage.enterToTextboxByIDName(driver, "mobile_number", mobile_number);
		signupPage.clickToButtonByLabel(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		accountCreatedPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		homePage.openMenuPage(driver, "Logout");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_02 - Step 03: Verify 'Login to your account' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "Login to your account"));
		
		log.info("Testcase_02 - Step 04: Enter correct email address and password");
		signupLoginPage.enterToTextboxByIDName(driver, "login-email", email);
		signupLoginPage.enterToTextboxByIDName(driver, "login-password", password);
		
		log.info("Testcase_02 - Step 05: Click 'login' button");
		signupLoginPage.clickToButtonByLabel(driver, "login-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_02 - Step 06: Verify that 'Logged in as username' is visible");
		verifyTrue(homePage.isLabelFormDisplayed(driver, "Logged in as " + username));
		
		log.info("Testcase_02 - Step 07: Click 'Delete Account' button");
		homePage.openMenuPage(driver, "Delete Account");
		deleteAccountPage = PageGenerator.getDeleteAccountPage(driver);
		
		log.info("Testcase_02 - Step 08: Verify that 'ACCOUNT DELETED!' is visible");
		verifyTrue(deleteAccountPage.isLabelFormDisplayed(driver, "ACCOUNT DELETED!"));
		deleteAccountPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 3: Login User with incorrect email and password")
	public void Testcase_03() {
		log.info("Testcase_03 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_03 - Step 02: Create new account");
		signupLoginPage.enterToTextboxByIDName(driver, "signup-name", username);
		signupLoginPage.enterToTextboxByIDName(driver, "signup-email", email);
		signupLoginPage.clickToButtonByLabel(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByIDName(driver, "name", username);
		signupPage.enterToTextboxByIDName(driver, "password", password);
		signupPage.selectItemInDropdownByName(driver, "days", day);
		signupPage.selectItemInDropdownByName(driver, "months", month);
		signupPage.selectItemInDropdownByName(driver, "years", year);
		signupPage.clickToCheckboxByID(driver, "newsletter");
		signupPage.clickToCheckboxByID(driver, "optin");
		signupPage.enterToTextboxByIDName(driver, "first_name", last_name);
		signupPage.enterToTextboxByIDName(driver, "last_name", first_name);
		signupPage.enterToTextboxByIDName(driver, "company", company);
		signupPage.enterToTextboxByIDName(driver, "address", address);
		signupPage.enterToTextboxByIDName(driver, "address2", address2);
		signupPage.selectItemInDropdownByName(driver, "country", country);
		signupPage.enterToTextboxByIDName(driver, "state", state);
		signupPage.enterToTextboxByIDName(driver, "city", city);
		signupPage.enterToTextboxByIDName(driver, "zipcode", zipcode);
		signupPage.enterToTextboxByIDName(driver, "mobile_number", mobile_number);
		signupPage.clickToButtonByLabel(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		accountCreatedPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		homePage.openMenuPage(driver, "Logout");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_03 - Step 03: Verify 'Login to your account' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "Login to your account"));
		
		log.info("Testcase_03 - Step 04: Enter correct email address and password");
		signupLoginPage.enterToTextboxByIDName(driver, "login-email", email);
		signupLoginPage.enterToTextboxByIDName(driver, "login-password", password + 0000);
		
		log.info("Testcase_03 - Step 05: Click 'login' button");
		signupLoginPage.clickToButtonByLabel(driver, "login-button");
		
		log.info("Testcase_03 - Step 06: Verify error 'Your email or password is incorrect!' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "Your email or password is incorrect!"));
		signupLoginPage.openMenuPage(driver, "Home");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 4: Logout User")
	public void Testcase_04() {
		log.info("Testcase_04 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_04 - Step 02: Create new account");
		signupLoginPage.enterToTextboxByIDName(driver, "signup-name", username);
		signupLoginPage.enterToTextboxByIDName(driver, "signup-email", email);
		signupLoginPage.clickToButtonByLabel(driver, "signup-button");
		signupPage = PageGenerator.getSignupPage(driver);
		
		signupPage.clickToRadioButtonByID(driver, "uniform-id_gender1");
		signupPage.enterToTextboxByIDName(driver, "name", username);
		signupPage.enterToTextboxByIDName(driver, "password", password);
		signupPage.selectItemInDropdownByName(driver, "days", day);
		signupPage.selectItemInDropdownByName(driver, "months", month);
		signupPage.selectItemInDropdownByName(driver, "years", year);
		signupPage.clickToCheckboxByID(driver, "newsletter");
		signupPage.clickToCheckboxByID(driver, "optin");
		signupPage.enterToTextboxByIDName(driver, "first_name", last_name);
		signupPage.enterToTextboxByIDName(driver, "last_name", first_name);
		signupPage.enterToTextboxByIDName(driver, "company", company);
		signupPage.enterToTextboxByIDName(driver, "address", address);
		signupPage.enterToTextboxByIDName(driver, "address2", address2);
		signupPage.selectItemInDropdownByName(driver, "country", country);
		signupPage.enterToTextboxByIDName(driver, "state", state);
		signupPage.enterToTextboxByIDName(driver, "city", city);
		signupPage.enterToTextboxByIDName(driver, "zipcode", zipcode);
		signupPage.enterToTextboxByIDName(driver, "mobile_number", mobile_number);
		signupPage.clickToButtonByLabel(driver, "create-account");
		accountCreatedPage = PageGenerator.getAccountCreatedPage(driver);
		
		accountCreatedPage.clickToButtonByLabel(driver, "continue-button");
		homePage = PageGenerator.getHomePage(driver);
		
		homePage.openMenuPage(driver, "Logout");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_04 - Step 03: Verify 'Login to your account' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "Login to your account"));
		
		log.info("Testcase_04 - Step 04: Enter correct email address and password");
		signupLoginPage.enterToTextboxByIDName(driver, "login-email", email);
		signupLoginPage.enterToTextboxByIDName(driver, "login-password", password);
		
		log.info("Testcase_04 - Step 05: Click 'login' button");
		signupLoginPage.clickToButtonByLabel(driver, "login-button");
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Testcase_04 - Step 06: Verify that 'Logged in as username' is visible");
		verifyTrue(homePage.isLabelFormDisplayed(driver, "Logged in as " + username));
		
		log.info("Testcase_04 - Step 07: Click 'Logout' button");
		homePage.openMenuPage(driver, "Logout");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_04 - Step 08: Verify that user is navigated to login page");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "Login to your account"));
		signupLoginPage.openMenuPage(driver, "Home");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 5: Register User with existing email")
	public void Testcase_05() {
		log.info("Testcase_05 - Step 01: Click on 'Signup / Login' button");
		homePage.openMenuPage(driver, "Signup / Login");
		signupLoginPage = PageGenerator.getSignupLoginPage(driver);
		
		log.info("Testcase_05 - Step 02: Verify 'New User Signup!' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "New User Signup!"));
		
		log.info("Testcase_05 - Step 03: Enter name and already registered email address");
		signupLoginPage.enterToTextboxByIDName(driver, "signup-name", username);
		signupLoginPage.enterToTextboxByIDName(driver, "signup-email", email);
		
		log.info("Testcase_05 - Step 04: Click 'Signup' button");
		signupLoginPage.clickToButtonByLabel(driver, "signup-button");
		
		log.info("Testcase_05 - Step 05: Verify error 'Email Address already exist!' is visible");
		verifyTrue(signupLoginPage.isLabelFormDisplayed(driver, "Email Address already exist!"));
		signupLoginPage.openMenuPage(driver, "Home");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 6: Contact Us Form")
	public void Testcase_06() {
		log.info("Testcase_06 - Step 01: Click on 'Contact Us' button");
		homePage.openMenuPage(driver, "Contact us");
		contactUsPage = PageGenerator.getContactUsPage(driver);
		
		log.info("Testcase_06 - Step 02: Verify 'GET IN TOUCH' is visible");
		verifyTrue(contactUsPage.isLabelFormDisplayed(driver, "GET IN TOUCH"));
		
		log.info("Testcase_06 - Step 03: Enter name, email, subject and message");
		contactUsPage.enterToTextboxByIDName(driver, "name", username);
		contactUsPage.enterToTextboxByIDName(driver, "email", email);
		contactUsPage.enterToTextboxByIDName(driver, "subject", "FEEDBACK");
		contactUsPage.enterToTextboxByIDName(driver, "message", "We really appreciate your response to our website.");
		
		log.info("Testcase_06 - Step 04: Upload file");
		contactUsPage.uploadImage(driver,  imagePath);
		
		log.info("Testcase_06 - Step 05: Click 'Submit' button");
		contactUsPage.clickToButtonByLabel(driver, "submit-button");
		
		log.info("Testcase_06 - Step 06: Click OK button");
		contactUsPage.acceptAlert(driver);
		
		log.info("Testcase_06 - Step 07: Verify success message 'Success! Your details have been submitted successfully.' is visible");
		verifyTrue(contactUsPage.isLabelFormDisplayed(driver, "Success! Your details have been submitted successfully."));
		
		log.info("Testcase_06 - Step 08: Click 'Home' button and verify that landed to home page successfully");
		contactUsPage.clickToButtonByXpath();
		homePage = PageGenerator.getHomePage(driver);
		verifyEquals(homePage.getPageUrl(driver), "https://automationexercise.com/");
	}
	
	@Test(description = "Test Case 7: Verify Test Cases Page")
	public void Testcase_07() {
		log.info("Testcase_07 - Step 01: Click on 'Test Cases' button");
		homePage.openMenuPage(driver, "Test Cases");
		testCasesPage = PageGenerator.getTestCasesPage(driver);
		
		log.info("Testcase_07 - Step 02: Verify user is navigated to test cases page successfully");
		verifyEquals(testCasesPage.getPageUrl(driver), "https://automationexercise.com/test_cases");
		testCasesPage.openMenuPage(driver, "Home");
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test(description = "Test Case 8: Verify All Products and product detail page")
	public void Testcase_08() {
		log.info("Testcase_08 - Step 01: Click on 'Products' button");
		homePage.openMenuPage(driver, "Products");
		productsPage = PageGenerator.getProductsPage(driver);
		
		log.info("Testcase_08 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		verifyTrue(productsPage.isLabelFormDisplayed(driver, "ALL PRODUCTS"));
		
		log.info("Testcase_08 - Step 03: The products list is visible");
		productsPage.isProductsVisible();
		
		log.info("Testcase_08 - Step 04: Click on 'View Product' of first product");
		productsPage.clickToViewProduct("1");
		
		log.info("Testcase_08 - Step 05: User is landed to product detail page");
		productsDetailPage = PageGenerator.getProductsDetailPage(driver);
		
		log.info("Testcase_08 - Step 06: Verify that detail is visible: product name, category, price, availability, condition, brand");
		verifyTrue(productsDetailPage.isProductsNameVisible());
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("1"));
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("2"));
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("3"));
		verifyTrue(productsDetailPage.isProductsCategoryAvailabilityContidionBrandVisible("4"));
	}
	
	@Test(description = "Test Case 9: Search Product")
	public void Testcase_09() {
		log.info("Testcase_09 - Step 01: Click on 'Products' button");
		productsDetailPage.openMenuPage(driver, "Products");
		productsPage = PageGenerator.getProductsPage(driver);
		
		log.info("Testcase_09 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		verifyTrue(productsPage.isLabelFormDisplayed(driver, "ALL PRODUCTS"));
		
		log.info("Testcase_09 - Step 03: Enter product name in search input and click search button");
		productsPage.enterToSearchTextbox("Top");
		productsPage.clickToSearchButton();
		
		log.info("Testcase_09 - Step 04: Verify 'SEARCHED PRODUCTS' is visible");
		verifyTrue(productsPage.isLabelFormDisplayed(driver, "SEARCHED PRODUCTS"));
		
		log.info("Testcase_09 - Step 05: Verify all the products related to search are visible");
		verifyTrue(productsPage.isSearchedProductsDisplayed("1"));
	}
	
	@Test(description = "Test Case 10: Verify Subscription in home page")
	public void Testcase_10() {
		log.info("Testcase_10 - Step 01: Scroll down to footer");
		
		
		log.info("Testcase_10 - Step 02: Verify text 'SUBSCRIPTION'");
		
		
		log.info("Testcase_10 - Step 03: Enter email address in input and click arrow button");
		
		
		log.info("Testcase_10 - Step 04: Verify success message 'You have been successfully subscribed!' is visible");
		
	}
	
	@Test(description = "Test Case 11: Verify Subscription in Cart page")
	public void Testcase_11() {
		log.info("Testcase_11 - Step 01: Click 'Cart' button");
		
		
		log.info("Testcase_11 - Step 02: Scroll down to footer");
		
		
		log.info("Testcase_11 - Step 03: Verify text 'SUBSCRIPTION'");
		
		
		log.info("Testcase_11 - Step 04: Enter email address in input and click arrow button");
		
		
		log.info("Testcase_11 - Step 05: Verify success message 'You have been successfully subscribed!' is visible");
		
	}
	
	@Test(description = "Test Case 12: Add Products in Cart")
	public void Testcase_12() {
		log.info("Testcase_12 - Step 01: Click 'Products' button");
		
		
		log.info("Testcase_12 - Step 02: Hover over first product and click 'Add to cart'");
		
		
		log.info("Testcase_12 - Step 03: Click 'Continue Shopping' button");
		
		
		log.info("Testcase_12 - Step 04: Hover over second product and click 'Add to cart'");
		
		
		log.info("Testcase_12 - Step 05: Click 'View Cart' button");
		
		
		log.info("Testcase_12 - Step 06: Verify both products are added to Cart");
		
		
		log.info("Testcase_12 - Step 07: Verify their prices, quantity and total price");
		
	}
	
	@Test(description = "Test Case 13: Verify Product quantity in Cart")
	public void Testcase_13() {
		log.info("Testcase_13 - Step 01: Click 'View Product' for any product on home page");
		
		
		log.info("Testcase_13 - Step 02: Verify product detail is opened");
		
		
		log.info("Testcase_13 - Step 03: Increase quantity to 4");
		
		
		log.info("Testcase_13 - Step 04: Click 'Add to cart' button");
		
		
		log.info("Testcase_13 - Step 05: Click 'View Cart' button");
		
		
		log.info("Testcase_13 - Step 06: Verify that product is displayed in cart page with exact quantity");
		
	}
	
	@Test(description = "Test Case 14: Place Order: Register while Checkout")
	public void Testcase_14() {
		log.info("Testcase_14 - Step 01: Add products to cart");
		
		
		log.info("Testcase_14 - Step 02: Click 'Cart' button");
		
		
		log.info("Testcase_14 - Step 03: Verify that cart page is displayed");
		
		
		log.info("Testcase_14 - Step 04: Click Proceed To Checkout");
		
		
		log.info("Testcase_14 - Step 05: Click 'Register / Login' button");
		
		
		log.info("Testcase_14 - Step 06: Fill all details in Signup and create account");
		
		
		log.info("Testcase_14 - Step 07: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		
		
		log.info("Testcase_14 - Step 08: Verify ' Logged in as username' at top");
		
		
		log.info("Testcase_14 - Step 09: Click 'Cart' button");
		
		
		log.info("Testcase_14 - Step 10: Click 'Proceed To Checkout' button");
		
		
		log.info("Testcase_14 - Step 11: Verify Address Details and Review Your Order");
		
		
		log.info("Testcase_14 - Step 12: Enter description in comment text area and click 'Place Order'");
		
		
		log.info("Testcase_14 - Step 13: Enter payment details: Name on Card, Card Number, CVC, Expiration date");
		
		
		log.info("Testcase_14 - Step 14: Click 'Pay and Confirm Order' button");
		
		
		log.info("Testcase_14 - Step 15: Verify success message 'Your order has been placed successfully!'");
		
		
		log.info("Testcase_14 - Step 16: Click 'Delete Account' button");
		
		
		log.info("Testcase_14 - Step 17: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Test(description = "Test Case 15: Place Order: Register before Checkout")
	public void Testcase_15() {
		log.info("Testcase_15 - Step 01: Click 'Signup / Login' button");
		
		
		log.info("Testcase_15 - Step 02: Fill all details in Signup and create account");
		
		
		log.info("Testcase_15 - Step 03: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		
		
		log.info("Testcase_15 - Step 04: Verify ' Logged in as username' at top");
		
		
		log.info("Testcase_15 - Step 05: Add products to cart");
		
		
		log.info("Testcase_15 - Step 06: Click 'Cart' button");
		
		
		log.info("Testcase_15 - Step 07: Verify that cart page is displayed");
		
		
		log.info("Testcase_15 - Step 08: Click Proceed To Checkout");
		
		
		log.info("Testcase_15 - Step 09: Verify Address Details and Review Your Order");
		
		
		log.info("Testcase_15 - Step 10: Enter description in comment text area and click 'Place Order'");
		
		
		log.info("Testcase_15 - Step 11: Enter payment details: Name on Card, Card Number, CVC, Expiration date");
		
		
		log.info("Testcase_15 - Step 12: Click 'Pay and Confirm Order' button");
		
		
		log.info("Testcase_15 - Step 13: Verify success message 'Your order has been placed successfully!'");
		
		
		log.info("Testcase_15 - Step 14: Click 'Delete Account' button");
		
		
		log.info("Testcase_15 - Step 15: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Test(description = "Test Case 16: Place Order: Login before Checkout")
	public void Testcase_16() {
		log.info("Testcase_16 - Step 01: Click 'Signup / Login' button");
		
		
		log.info("Testcase_16 - Step 02: Fill email, password and click 'Login' button");
		
		
		log.info("Testcase_16 - Step 03: Verify 'Logged in as username' at top");
		
		
		log.info("Testcase_16 - Step 04: Add products to cart");
		
		
		log.info("Testcase_16 - Step 05: Click 'Cart' button");
		
		
		log.info("Testcase_16 - Step 06: Verify that cart page is displayed");
		
		
		log.info("Testcase_16 - Step 07: Click Proceed To Checkout");
		
		
		log.info("Testcase_16 - Step 08: Verify Address Details and Review Your Order");
		
		
		log.info("Testcase_16 - Step 09: Enter description in comment text area and click 'Place Order'");
		
		
		log.info("Testcase_16 - Step 10: Enter payment details: Name on Card, Card Number, CVC, Expiration date");
		
		
		log.info("Testcase_16 - Step 11: Click 'Pay and Confirm Order' button");
		
		
		log.info("Testcase_16 - Step 12: Verify success message 'Your order has been placed successfully!'");
		
		
		log.info("Testcase_16 - Step 13: Click 'Delete Account' button");
		
		
		log.info("Testcase_16 - Step 14: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Test(description = "Test Case 17: Remove Products From Cart")
	public void Testcase_17() {
		log.info("Testcase_17 - Step 01: Add products to cart");
		
		
		log.info("Testcase_17 - Step 02: Click 'Cart' button");
		
		
		log.info("Testcase_17 - Step 03: Verify that cart page is displayed");
		
		
		log.info("Testcase_17 - Step 04: Click 'X' button corresponding to particular product");
		
		
		log.info("Testcase_17 - Step 05: Verify that product is removed from the cart");
		
	}
	
	@Test(description = "Test Case 18: View Category Products")
	public void Testcase_18() {
		log.info("Testcase_18 - Step 01: Click on 'Women' category");
		
		
		log.info("Testcase_18 - Step 02: Click on any category link under 'Women' category, for example: Dress");
		
		
		log.info("Testcase_18 - Step 03: Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'");
		
		
		log.info("Testcase_18 - Step 04: On left side bar, click on any sub-category link of 'Men' category");
		
		
		log.info("Testcase_18 - Step 05: Verify that user is navigated to that category page");
		
	}
	
	@Test(description = "Test Case 19: View & Cart Brand Products")
	public void Testcase_19() {
		log.info("Testcase_19 - Step 01: Click on 'Products' button");
		
		
		log.info("Testcase_19 - Step 02: Verify that Brands are visible on left side bar");
		
		
		log.info("Testcase_19 - Step 03: Click on any brand name");
		
		
		log.info("Testcase_19 - Step 04: Verify that user is navigated to brand page and brand products are displayed");
		
		
		log.info("Testcase_19 - Step 05: On left side bar, click on any other brand link");
		
		
		log.info("Testcase_19 - Step 06: Verify that user is navigated to that brand page and can see products");
		
	}
	
	@Test(description = "Test Case 20: Search Products and Verify Cart After Login")
	public void Testcase_20() {
		log.info("Testcase_20 - Step 01: Click on 'Products' button");
		
		
		log.info("Testcase_20 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		
		
		log.info("Testcase_20 - Step 03: Enter product name in search input and click search button");
		
		
		log.info("Testcase_20 - Step 04: Verify 'SEARCHED PRODUCTS' is visible");
		
		
		log.info("Testcase_20 - Step 05: Verify all the products related to search are visible");
		
		
		log.info("Testcase_20 - Step 06: Add those products to cart");
		
		
		log.info("Testcase_20 - Step 07: Click 'Cart' button and verify that products are visible in cart");
		
		
		log.info("Testcase_20 - Step 08: Click 'Signup / Login' button and submit login details");
		
		
		log.info("Testcase_20 - Step 09: Again, go to Cart page");
		
		
		log.info("Testcase_20 - Step 10: Verify that those products are visible in cart after login as well");
		
	}
	
	@Test(description = "Test Case 21: Add review on product")
	public void Testcase_21() {
		log.info("Testcase_21 - Step 01: Click on 'Products' button");
		
		
		log.info("Testcase_21 - Step 02: Verify user is navigated to ALL PRODUCTS page successfully");
		
		
		log.info("Testcase_21 - Step 03: Click on 'View Product' button");
		
		
		log.info("Testcase_21 - Step 04: Verify 'Write Your Review' is visible");
		
		
		log.info("Testcase_21 - Step 05: Enter name, email and review");
		
		
		log.info("Testcase_21 - Step 06: Click 'Submit' button");
		
		
		log.info("Testcase_21 - Step 07: Verify success message 'Thank you for your review.'");
		
	}
	
	@Test(description = "Test Case 22: Add to cart from Recommended items")
	public void Testcase_22() {
		log.info("Testcase_22 - Step 01: Scroll to bottom of page");
		
		
		log.info("Testcase_22 - Step 02: Verify 'RECOMMENDED ITEMS' are visible");
		
		
		log.info("Testcase_22 - Step 03: Click on 'Add To Cart' on Recommended product");
		
		
		log.info("Testcase_22 - Step 04: Click on 'View Cart' button");
		
		
		log.info("Testcase_22 - Step 05: Verify that product is displayed in cart page");
		
	}
	
	@Test(description = "Test Case 23: Verify address details in checkout page")
	public void Testcase_23() {
		log.info("Testcase_23 - Step 01: Click 'Signup / Login' button");
		
		
		log.info("Testcase_23 - Step 02: Fill all details in Signup and create account");
		
		
		log.info("Testcase_23 - Step 03: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		
		
		log.info("Testcase_23 - Step 04: Verify ' Logged in as username' at top");
		
		
		log.info("Testcase_23 - Step 05: Add products to cart");
		
		
		log.info("Testcase_23 - Step 06: Click 'Cart' button");
		
		
		log.info("Testcase_23 - Step 07: Verify that cart page is displayed");
		
		
		log.info("Testcase_23 - Step 08: Click Proceed To Checkout");
		
		
		log.info("Testcase_23 - Step 09: Verify that the delivery address is same address filled at the time registration of account");
		
		
		log.info("Testcase_23 - Step 10: Verify that the billing address is same address filled at the time registration of account");
		
		
		log.info("Testcase_23 - Step 11: Click 'Delete Account' button");
		
		
		log.info("Testcase_23 - Step 12: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Test(description = "Test Case 24: Download Invoice after purchase order")
	public void Testcase_24() {
		log.info("Testcase_24 - Step 01: Add products to cart");
		
		
		log.info("Testcase_24 - Step 02: Click 'Cart' button");
		
		
		log.info("Testcase_24 - Step 03: Verify that cart page is displayed");
		
		
		log.info("Testcase_24 - Step 04: Click Proceed To Checkout");
		
		
		log.info("Testcase_24 - Step 05: Click 'Register / Login' button");
		
		
		log.info("Testcase_24 - Step 06: Fill all details in Signup and create account");
		
		
		log.info("Testcase_24 - Step 07: Verify 'ACCOUNT CREATED!' and click 'Continue' button");
		
		
		log.info("Testcase_24 - Step 08: Verify ' Logged in as username' at top");
		
		
		log.info("Testcase_24 - Step 09: Click 'Cart' button");
		
		
		log.info("Testcase_24 - Step 10: Click 'Proceed To Checkout' button");
		
		
		log.info("Testcase_24 - Step 11: Verify Address Details and Review Your Order");
		
		
		log.info("Testcase_24 - Step 12: Enter description in comment text area and click 'Place Order'");
		
		
		log.info("Testcase_24 - Step 13: Enter payment details: Name on Card, Card Number, CVC, Expiration date");
		
		
		log.info("Testcase_24 - Step 14: Click 'Pay and Confirm Order' button");
		
		
		log.info("Testcase_24 - Step 15: Verify success message 'Your order has been placed successfully!'");
		
		
		log.info("Testcase_24 - Step 16: Click 'Download Invoice' button and verify invoice is downloaded successfully.");
		
		
		log.info("Testcase_24 - Step 17: Click 'Continue' button");
		
		
		log.info("Testcase_24 - Step 18: Click 'Delete Account' button");
		
		
		log.info("Testcase_24 - Step 19: Verify 'ACCOUNT DELETED!' and click 'Continue' button");
		
	}
	
	@Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
	public void Testcase_25() {
		log.info("Testcase_25 - Step 01: Scroll down page to bottom");
		
		
		log.info("Testcase_25 - Step 02: Verify 'SUBSCRIPTION' is visible");
		
		
		log.info("Testcase_25 - Step 03: Click on arrow at bottom right side to move upward");
		
		
		log.info("Testcase_25 - Step 04: Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
		
	}
	
	@Test(description = "Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
	public void Testcase_26() {
		log.info("Testcase_26 - Step 01: Scroll down page to bottom");
		
		
		log.info("Testcase_26 - Step 02: Verify 'SUBSCRIPTION' is visible");
		
		
		log.info("Testcase_26 - Step 03: Scroll up page to top");
		
		
		log.info("Testcase_26 - Step 04: Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
		
	}
	
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
