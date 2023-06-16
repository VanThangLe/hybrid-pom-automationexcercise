package pageUIs.automationexercise;

public class BasePageUI {
	public static final String MENU_BY_PAGE_NAME = "//a[contains(text(),'%s')]";
	public static final String TEXTBOX_BY_ID_NAME = "//input[@data-qa='%s']";
	public static final String DROPDOWN_BY_NAME = "//select[@data-qa='%s']";
	public static final String UPLOAD_FILE = "//input[@type='file']";
	public static final String BUTTON_BY_LABEL = "//button[@data-qa='%s']";
	public static final String RADIO_BUTTON_BY_ID = "//div[@id='%s']";
	public static final String CHECKBOX_BY_ID = "//input[@id='%s']";
	public static final String TITLE_FORM = "//*[contains(text(), '%s')]";
}