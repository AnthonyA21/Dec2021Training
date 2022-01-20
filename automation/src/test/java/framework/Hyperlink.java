package framework;

import org.openqa.selenium.WebElement;

public class Hyperlink {
	private WebElement mappedElement;

	public Hyperlink(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public void click (String label) {
		this.mappedElement.click();
		//String actualValue = getValue();

		//if(!actualValue.equals(text)) {
			//throw new RuntimeException("The value '" + text + "' was not set.");
		//}
	}
}
