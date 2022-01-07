package seleniumDev.pages;

import org.openqa.selenium.WebDriver;

public class DocumentationPage extends PageObjectBase {
	public DocumentationPage(WebDriver driver) {
	    super(driver);
	}
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
}
