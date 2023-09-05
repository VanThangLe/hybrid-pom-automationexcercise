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
	public static final String TEXTAREA_BY_ID_NAME = "//textarea[@id='%s']";
	
	public static final String PRODUCT_LISTS = "//div[@id='cartModal']/following-sibling::div['%s']";
	public static final String SINGLE_PRODUCTS = PRODUCT_LISTS + "//div[@class='product-overlay']//a";
	public static final String VIEW_PRODUCT_XPATH = "//a[@href='/product_details/%s']";
	
	public static final String CONTINUE_SHOPPING_BUTTON = "//button[contains(text(),'Continue Shopping')]";
	
	public static final String DELIVERY_ADDRESS = "//ul[@id='address_delivery']/li['%s']";
	public static final String BILLING_ADDRESS = "//ul[@id='address_invoice']/li['%s']";
}