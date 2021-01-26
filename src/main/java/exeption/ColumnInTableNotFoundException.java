package exeption;

import org.openqa.selenium.WebDriverException;

public class ColumnInTableNotFoundException extends WebDriverException {

	private String message;

	public ColumnInTableNotFoundException(String message) {
		this.message = message;
	}

	public String getmessage() {
		return this.message;
	}

}
