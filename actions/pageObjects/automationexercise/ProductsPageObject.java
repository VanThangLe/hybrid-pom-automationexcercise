package pageObjects.automationexercise;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.automationexercise.ProductsPageUI;

public class ProductsPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductsPageObject(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public boolean isProductsVisible() {
		waitForElementVisible(driver, ProductsPageUI.PRODUCTS_VISIBLE_XPATH);
		return isElementDisplayed(driver, ProductsPageUI.PRODUCTS_VISIBLE_XPATH);
	}

	public void clickToViewProduct(String value) {
		waitForElementClickAble(driver, ProductsPageUI.VIEW_PRODUCT_XPATH, value);
		clickToElement(driver, ProductsPageUI.VIEW_PRODUCT_XPATH, value);
	}

	public void enterToSearchTextbox(String searchText) {
		waitForElementVisible(driver, ProductsPageUI.SEARCH_TEXTBOX_BY_NAME, searchText);
		sendkeyToElement(driver, ProductsPageUI.SEARCH_TEXTBOX_BY_NAME, searchText);
	}
	
	public void clickToSearchButton() {
		waitForElementClickAble(driver, ProductsPageUI.SEARCH_BUTTON_BY_ID);
		clickToElement(driver, ProductsPageUI.SEARCH_BUTTON_BY_ID);
	}

	public boolean isSearchedProductsDisplayed(String value) {
		waitForElementVisible(driver, ProductsPageUI.SEARCHED_PRODUCTS, value);
		return isElementDisplayed(driver, ProductsPageUI.SEARCHED_PRODUCTS, value);
	}
}
