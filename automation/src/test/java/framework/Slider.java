package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Slider {

	private WebElement mappedElement;

	public Slider(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public String getValue() {
		return this.mappedElement.getAttribute("value");
	}

	public void setValue(String valueStr, JavascriptExecutor jse) {
		int intValue = Integer.parseInt(valueStr);
		jse.executeScript("$(arguments[0]).val("+intValue+").change()", this.mappedElement);

	}
	
	
}
