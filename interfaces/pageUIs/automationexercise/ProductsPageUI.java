package pageUIs.automationexercise;

public class ProductsPageUI {
	public static final String PRODUCTS_VISIBLE_XPATH = "//div[@class='features_items']";
	public static final String VIEW_PRODUCT_XPATH = "//a[@href='/product_details/%s']";
	public static final String SEARCH_TEXTBOX_BY_NAME = "//input[@name='search']";
	public static final String SEARCH_BUTTON_BY_ID = "//button[@id='submit_search']";
	public static final String SEARCHED_PRODUCTS= "//div[@id='cartModal']/following-sibling::div[%s]";
}