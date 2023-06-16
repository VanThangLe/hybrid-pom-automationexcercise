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
}
