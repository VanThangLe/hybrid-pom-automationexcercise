package pageObjects.automationexercise;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.automationexercise.ContactUsPageUI;

public class ContactUsPageObject extends BasePage {
	private WebDriver driver;
	
	public ContactUsPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clickToHomeButton() {
		waitForElementClickAble(driver, ContactUsPageUI.HOME_BUTTON);
		clickToElement(driver, ContactUsPageUI.HOME_BUTTON);
	}
}
