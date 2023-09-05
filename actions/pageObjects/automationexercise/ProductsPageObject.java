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
}
