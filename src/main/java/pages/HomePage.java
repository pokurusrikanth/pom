package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.EventMethods;

public class HomePage extends EventMethods {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Home']")
	private WebElement linkhome;

	@FindBy(xpath = "//span[text()='Companies']")
	private WebElement companieslink;

	public void click_on_companies() {
		highLight_element(companieslink);
		companieslink.click();
	}

	public boolean homePageDisplayed() {
		boolean isfound = false;
		if (linkhome != null) {
			if (linkhome.isDisplayed()) {
				isfound = true;
			}
		}
		return isfound;
	}
}
