package pageObjects.automationexercise;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.automationexercise.ContactUsPageUI;

public class ContactUsPageObject extends BasePage {
	private WebDriver driver;
	
	public ContactUsPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clickToButtonByXpath() {
		waitForElementClickAble(driver, ContactUsPageUI.BUTTON_XPATH);
		clickToElement(driver, ContactUsPageUI.BUTTON_XPATH);
	}
}
