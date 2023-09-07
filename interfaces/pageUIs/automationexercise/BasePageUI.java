package pageUIs.automationexercise;

public class BasePageUI {
	public static final String MENU_BY_PAGE_NAME = "//a[contains(text(),'%s')]";
	public static final String TEXTBOX_BY_DATA_QA = "//input[@data-qa='%s']";
	public static final String TEXTBOX_BY_ID_NAME = "//input[@id='%s']";
	public static final String DROPDOWN_BY_NAME = "//select[@data-qa='%s']";
	public static final String UPLOAD_FILE = "//input[@type='file']";
	public static final String BUTTON_BY_DATA_QA = "//button[@data-qa='%s']";
	public static final String BUTTON_BY_ID_NAME = "//button[@id='%s']";
	public static final String RADIO_BUTTON_BY_ID = "//div[@id='%s']";
	public static final String CHECKBOX_BY_ID = "//input[@id='%s']";
	public static final String TITLE_TEXT = "//*[contains(text(), '%s')]";
	public static final String TEXTAREA_BY_ID_NAME = "//textarea[@name='%s']";
	
	public static final String PRODUCT_LISTS = "//div[@id='cartModal']/following-sibling::div[%s]";
	public static final String SINGLE_PRODUCTS_IN_LIST = "//div[@id='cartModal']/following-sibling::div[%s]//div[@class='product-overlay']//a";
	public static final String VIEW_PRODUCT_IN_LIST = "//div[@id='cartModal']/following-sibling::div[%s]//a[contains(text(),'View Product')]";
	public static final String PRODUCT_NAME_IN_LIST = "//div[@id='cartModal']/following-sibling::div[%s]//div[@class='productinfo text-center']//p";
	public static final String PRODUCT_PRICE_IN_LIST = "//div[@id='cartModal']/following-sibling::div[%s]//div[@class='productinfo text-center']//h2";
	
	public static final String DELIVERY_ADDRESS = "//ul[@id='address_delivery']/li[%s]";
	public static final String BILLING_ADDRESS = "//ul[@id='address_invoice']/li[%s]";
}