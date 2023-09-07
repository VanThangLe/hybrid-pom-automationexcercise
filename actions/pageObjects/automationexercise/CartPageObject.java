package pageObjects.automationexercise;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.automationexercise.CartPageUI;

public class CartPageObject extends BasePage {
	private WebDriver driver;
	
	public CartPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public String getProductLinkInCart(String productIndex, String value) {
		waitForElementVisible(driver, CartPageUI.PRODUCT_LINK, productIndex, value);
		return getElementText(driver, CartPageUI.PRODUCT_LINK, productIndex, value);
	}
	
	public String getProductPriceInCart(String productIndex, String value) {
		waitForElementVisible(driver, CartPageUI.PRODUCT_PRICE, productIndex, value);
		return getElementText(driver, CartPageUI.PRODUCT_PRICE, productIndex, value);
	}
	
	public String getProductQuantityInCart(String productIndex) {
		waitForElementVisible(driver, CartPageUI.PRODUCT_QUANTITY, productIndex);
		return getElementText(driver, CartPageUI.PRODUCT_QUANTITY, productIndex);
	}
}
