package pageObjects.automationexercise;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.automationexercise.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clickToScollUpIcon() {
		waitForElementVisible(driver, HomePageUI.SCROLL_UP_ICON);
		clickToElement(driver, HomePageUI.SCROLL_UP_ICON);
	}
	
	public boolean isTitleTextDisplayed(String textValue) {
		waitForElementVisible(driver, HomePageUI.TEXT_XPATH, textValue);
		return isElementDisplayed(driver, HomePageUI.TEXT_XPATH, textValue);
	}
}
