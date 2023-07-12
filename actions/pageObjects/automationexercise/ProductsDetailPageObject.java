package pageObjects.automationexercise;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.automationexercise.ProductsDetailPageUI;

public class ProductsDetailPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductsDetailPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isProductsNameVisible() {
		waitForElementVisible(driver, ProductsDetailPageUI.PRODUCT_NAME_XPATH);
		return isElementDisplayed(driver, ProductsDetailPageUI.PRODUCT_NAME_XPATH);
	}
	
	public boolean isProductsCategoryAvailabilityContidionBrandVisible(String value) {
		waitForElementVisible(driver, ProductsDetailPageUI.PRODUCT_CATEGORY_AVAILABILITY_CONDITION_BRAND_XPATH, value);
		return isElementDisplayed(driver, ProductsDetailPageUI.PRODUCT_CATEGORY_AVAILABILITY_CONDITION_BRAND_XPATH, value);
	}
}
