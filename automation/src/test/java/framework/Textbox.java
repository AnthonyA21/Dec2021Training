package framework;

import org.openqa.selenium.WebElement;

public class Textbox {

	private WebElement mappedElement;

	public Textbox(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public String getValue() {
		return this.mappedElement.getAttribute("value");
	}

	public void setValue(String text) {
		this.mappedElement.sendKeys(text);
		String actualValue = getValue();

		if(!actualValue.equals(text)) {
			throw new RuntimeException("The value '" + text + "' was not set.");
		}
	}
}