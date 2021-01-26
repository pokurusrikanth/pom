package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import exeption.ColumnInTableNotFoundException;
import exeption.ElementIsNotWebelementexception;

public class Webtable {

	private WebElement table;

	public Webtable(WebElement element) {

		String tagname = element.getTagName();

		if (tagname.equalsIgnoreCase("table")) {
			table = element;
		} else {
			throw new ElementIsNotWebelementexception(
					"given element is not a valid webtable  element tagname must be start with 'table' but given element tagname is "
							+ tagname);

		}

	}

	public int getrowcount() {
		int totalrows = table.findElements(By.tagName("tr")).size();
		return totalrows;
	}

	public int getRowNumByText(String texttofind) {
		int rownum = -1;
		int columnnum = -1;
		List<WebElement> allrows = table.findElements(By.tagName("tr"));
		allrows: for (int i = 0; i < allrows.size(); i++) {
			WebElement row = allrows.get(i);
			List<WebElement> allcells;
			if (i == 0) {
				allcells = row.findElements(By.tagName("th"));
				allcells = (allcells.size() == 0) ? row.findElements(By.tagName("td")) : allcells;
			} else {
				allcells = row.findElements(By.tagName("td"));
			}
			for (int j = 0; j < allcells.size(); j++) {
				String celltext = allcells.get(j).getText();
				if (celltext.equalsIgnoreCase(texttofind)) {
					rownum = i;
					columnnum = j;
					break allrows;
				}
			}

		}
		return rownum;
	}

	public int getRowNumByText(String texttofind, String columnname) {
		int rownum = -1;
		int colposition = getColumnPosition(columnname);
		if (colposition == -1) {
			throw new ColumnInTableNotFoundException("column name is not found with given" + columnname);
		} else {
			List<WebElement> totalrows = table.findElements(By.tagName("tr"));
			for (int rnum = 1; rnum <= totalrows.size() - 1; rnum++) {
				WebElement row = totalrows.get(rnum);
				WebElement cell = row.findElements(By.tagName("td")).get(colposition);
				if (cell.getText().equalsIgnoreCase(texttofind)) {
					rownum = rnum;
					break;
				}

			}
		}
		return rownum;
	}

	public int getColumnPosition(String columnname) {
		int colnum = -1;
		WebElement headerrow = table.findElement(By.tagName("tr"));
		List<WebElement> allheaders = headerrow.findElements(By.tagName("th"));
		if (allheaders.size() == 0) {
			allheaders = headerrow.findElements(By.tagName("td"));
		}
		for (int i = 0; i <= allheaders.size() - 1; i++) {
			WebElement header = allheaders.get(i);
			if (header.getText().equalsIgnoreCase(columnname)) {
				colnum = i;
				break;
			}
		}
		return colnum;
	}
}
