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
		waitForElementVisible(driver, HomePageUI.TITLE_TEXT, textValue);
		return isElementDisplayed(driver, HomePageUI.TITLE_TEXT, textValue);
	}

	public void addRecommendProducts(String recommendProductIndex) {
		waitForElementClickAble(driver, HomePageUI.RECOMMEND_ADD_TO_CART, recommendProductIndex);
		clickToElement(driver, HomePageUI.RECOMMEND_ADD_TO_CART, recommendProductIndex);
	}
}
