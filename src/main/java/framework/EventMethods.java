package framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EventMethods {
	private WebDriver driver;

	public EventMethods(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verify_element_exists(By by, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.pollingEvery(Duration.ofMillis(200));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	protected void enter_value_in_textfield(By by, String input) {

	}

	protected void highLight_element(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;')", element);
	}

	protected void click(WebElement element) {
		try {
			highLight_element(element);
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			} else {
				Assert.assertTrue(false, "element" + element.toString() + "is either not visible or not enabled ");
			}
		} catch (NoSuchElementException nse) {
			Assert.assertTrue(false, "element" + element.toString() + "is not found in the page ");

		}

	}
}
