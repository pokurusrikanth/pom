package exeption;

import org.openqa.selenium.WebDriverException;

public class ElementIsNotWebelementexception extends WebDriverException {

	private String message;

	public ElementIsNotWebelementexception(String message) {
		this.message = message;
	}

	public String getmessage() {
		return this.message;
	}

}
