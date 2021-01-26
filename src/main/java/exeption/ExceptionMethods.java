package exeption;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExceptionMethods {

	public void select_value_from_the_list(WebElement listbox, String valuetoselect) throws ValueInTheListBoxNotFound {

		boolean isvaluefound = false;
		List<WebElement> alloptions = listbox.findElements(By.tagName("option"));

		for (WebElement option : alloptions) {
			if (option.getText().equalsIgnoreCase(valuetoselect)) {
				option.click();
				isvaluefound = true;
				break;
			}
		}

		if (!isvaluefound) {
			throw new ValueInTheListBoxNotFound(
					"value:" + valuetoselect + "is not found in the list box" + listbox.toString());
		}

	}

}
