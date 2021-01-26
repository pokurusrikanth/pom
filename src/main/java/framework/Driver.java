package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private WebDriver driver;

	public Driver(String browsername, int time) {
		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			this.driver = new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			this.driver = new InternetExplorerDriver();
			break;
		default:
			Assert.assertTrue(false, "the browser is in valid" + browsername
					+ "browser must be in given('chrome','firefox','edge','internetexplorer')");
			break;
		}
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public WebDriver getdriver() {
		return this.driver;
	}

}
