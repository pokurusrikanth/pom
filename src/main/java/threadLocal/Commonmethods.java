package threadLocal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import listener.Data;

public class Commonmethods {
	private static ThreadLocal<Commonmethods> threaddata = new ThreadLocal<Commonmethods>();

	public static void set(Commonmethods data) {
		threaddata.set(data);
	}

	public static Commonmethods get() {
		return threaddata.get();
	}

	public void Launching_Application(String browser, String url) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Data.get().driver = new ChromeDriver();
			break;
		case "firfox":
			WebDriverManager.firefoxdriver().setup();
			Data.get().driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.edgedriver().setup();
			Data.get().driver = new EdgeDriver();
			break;
		}
		Data.get().driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Data.get().driver.manage().window().maximize();
		Data.get().driver.get("http://ui.cogmento.com");
	}

	public void Login(String username, String password) {
		Data.get().driver.findElement(By.name("email")).sendKeys(username);
		Data.get().driver.findElement(By.name("password")).sendKeys(password);
		Data.get().driver.findElement(By.xpath("//div[text()='Login']")).click();
		;
	}
}
