package framework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonMethods extends EventMethods {

	private WebDriver driver;

	public CommonMethods(WebDriver driver) {
		super(driver);

		this.driver = driver;
	}

	public void navigate_to_url(String url) {
		driver.get(url);
		if (!verify_element_exists(By.name("email"), 20)) {
			Assert.assertTrue(false, "application is not navigated to login page");
		}
	}

	public void closeProcess() {
		String[] proceses = { "chrome.exe", "firefox.exe", "edge.exe", "chromedriver.exe", "geckodriver.exe",
				"microsoftwebdriver.exe" };
		for (String allproceses : proceses) {

			try {
				Runtime.getRuntime().exec("taskkill /F /IM " + allproceses);
			} catch (IOException e) {

			}

		}
	}

	public void login(String username, String password) {

	}
}
