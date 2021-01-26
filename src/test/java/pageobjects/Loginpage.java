package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	public WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Email")
	private WebElement usernamefield;

	@FindBy(name = "Password")
	private WebElement passwordfield;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginfield;

}
