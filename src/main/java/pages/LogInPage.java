package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.EventMethods;

public class LogInPage extends EventMethods {
	private WebDriver driver;

	public LogInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	private WebElement usernamefield;

	@FindBy(name = "password")
	private WebElement passwordfield;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginfield;

	public void login(String username, String password) {
		highLight_element(usernamefield);
		usernamefield.sendKeys(username);
		highLight_element(passwordfield);
		passwordfield.sendKeys(password);
		highLight_element(loginfield);
		loginfield.click();

	}
}
