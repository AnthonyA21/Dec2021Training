package seleniumDev.pages;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectBase {
	protected WebDriver driver;

	protected PageObjectBase(WebDriver driver) {
		this.driver = driver;
	}
}