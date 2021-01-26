package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import framework.Data;
import framework.EventMethods;

public class NewCompanyPage extends EventMethods {

	private WebDriver driver;

	public NewCompanyPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='image']")
	private WebElement companylogo;

	@FindBy(xpath = "//div[text()='Create new Company']")
	private WebElement staticcreatnewcompanyelement;

	public void click_on_companylogo(String imagename) throws InterruptedException {

		imagename = Data.Datafolderpath + "\\CompanyLogo.png" + imagename;
		click(companylogo);
		Thread.sleep(10000);

		try {
			Screen screen = new Screen();
			Pattern inputfilepath = new Pattern(Data.object_imagepath + "fileobject.png");
			Pattern openbutton = new Pattern(Data.object_imagepath + "openbutton.png");
			screen.type(inputfilepath, imagename);

			Thread.sleep(5000);
			screen.click(openbutton);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean creatNewCompanyElementDisplayed() {
		boolean isfound = false;
		if (staticcreatnewcompanyelement != null && staticcreatnewcompanyelement.isDisplayed()) {
			isfound = true;
		}
		return isfound;

	}
}
