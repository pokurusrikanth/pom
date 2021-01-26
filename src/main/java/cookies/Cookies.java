package cookies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies implements ITestListener {

	@Test
	public void getting_cookies() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://login.salesforce.com");
		driver.findElement(By.name("username")).sendKeys("cbsureshbabu1-mcfh@force.com");
		driver.findElement(By.name("pw")).sendKeys("jayalakshmi@1");
		driver.findElement(By.id("Login")).click();

		Set<Cookie> cookies = driver.manage().getCookies();
		Properties props = new Properties();
		for (Cookie cookie : cookies) {
			props.put(cookie.getName(), cookie.getValue());
		}
		File fil = new File("D:\\Users\\Srikath\\eclipse-workspace\\PageObjectModel\\config\\cookies.properties");
		FileOutputStream fos = new FileOutputStream(fil);
		props.store(fos, "");

	}

	@Test
	public void add_cookies() throws IOException {

		Calendar cal = Calendar.getInstance();
		java.util.Date dt = new java.util.Date();
		cal.setTime(dt);
		System.out.println(dt);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://login.salesforce.com");
		driver.findElement(By.name("username")).sendKeys("cbsureshbabu1-mcfh@force.com");
		driver.findElement(By.name("pw")).sendKeys("jayalakshmi@1");
		driver.findElement(By.id("Login")).click();

		FileInputStream fio = new FileInputStream(
				"D:\\Users\\Srikath\\eclipse-workspace\\PageObjectModel\\config\\cookies.properties");
		Properties props = new Properties();
		props.load(fio);
		Set<Object> propertieskey = props.keySet();
		for (Object propertiekey : propertieskey) {
			String propertiename = propertiekey.toString();
			String propertievalue = props.getProperty(propertiename);
			Cookie cookie = new Cookie(propertiename, propertievalue);
			driver.manage().addCookie(cookie);

			System.out.println(cookie);

		}
	}

	@Test
	public void checking_the_brokenlinks() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("http://twitter.com");
		driver.get("http://facebook.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String linkurl = link.getAttribute("href");
			URL url = new URL(linkurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			System.out.println(connection.getResponseCode() + ":" + connection.getURL());
			break;
		}

	}

	@Test
	public void sft_login_withuserdata() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\Srikath\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://google.com");

	}
}
