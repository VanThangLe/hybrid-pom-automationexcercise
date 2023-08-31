package pageObjects.automationexercise;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static SignupLoginPageObject getSignupLoginPage(WebDriver driver) {
		return new SignupLoginPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static SignupPageObject getSignupPage(WebDriver driver) {
		return new SignupPageObject(driver);
	}

	public static AccountCreatedPageObject getAccountCreatedPage(WebDriver driver) {
		return new AccountCreatedPageObject(driver);
	}

	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}

	public static ContactUsPageObject getContactUsPage(WebDriver driver) {
		return new ContactUsPageObject(driver);
	}

	public static TestCasesPageObject getTestCasesPage(WebDriver driver) {
		return new TestCasesPageObject(driver);
	}

	public static ProductsPageObject getProductsPage(WebDriver driver) {
		return new ProductsPageObject(driver);
	}
	
	public static ProductsDetailPageObject getProductsDetailPage(WebDriver driver) {
		return new ProductsDetailPageObject(driver);
	}
	
	public static CartPageObject getCartPage(WebDriver driver) {
		return new CartPageObject(driver);
	}
	
	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}
}
