package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.EventMethods;

public class CompaniesPage extends EventMethods {
	private WebDriver driver;

	public CompaniesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Companies']")
	private WebElement staticcompaniesheaderelement;

	@FindBy(xpath = "//button[text()='New']")
	private WebElement buttonnewcompany;

	public void click_on_newcompanybutton() {
		highLight_element(buttonnewcompany);
		buttonnewcompany.click();
	}

	public boolean comaniespagedisplayed() {
		boolean isfound = false;

		if (staticcompaniesheaderelement != null && staticcompaniesheaderelement.isDisplayed()) {
			isfound = true;
		}

		return isfound;

	}

}
