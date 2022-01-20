package framework;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OldStyleDropdownList {
	private WebElement mappedElement;
	
	public OldStyleDropdownList(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public String getValue() {
		Select colorMenu = new Select(this.mappedElement);			
		WebElement option = colorMenu.getFirstSelectedOption();
		return option.getText();
		//return this.mappedElement.getAttribute("value");
	}

	public void setValue(String text) {
		Select colorMenu = new Select(this.mappedElement);			
		colorMenu.selectByVisibleText(text);
	}
	
	public String[] getOptions() {
		Select colorMenu = new Select(this.mappedElement);			
		List<WebElement> menuElements = colorMenu.getOptions();
		String[] colorOptions = new String[menuElements.size()];
		for (int i = 0; i < menuElements.size(); i++) {
			colorOptions[i] = menuElements.get(i).getText();
		}
		return colorOptions;
	}
}
