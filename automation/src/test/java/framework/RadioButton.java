package framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RadioButton {
	private WebElement mappedElement;
	public RadioButton(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public void select(String label) {
		this.mappedElement.sendKeys(Keys.SPACE);

	}

	public String getSelected() {
		return this.mappedElement.getText();
	}
	
//	public boolean isEnabled() {
//		return this.mappedElement.isEnabled();
//	}
	
}
