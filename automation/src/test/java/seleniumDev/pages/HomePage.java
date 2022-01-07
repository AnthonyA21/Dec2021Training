package seleniumDev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObjectBase {

	public final String homeUrl = "https://www.selenium.dev/";

	public HomePage(WebDriver driver) {
	    super(driver);
	}
	
	public DocumentationPage viewHomepageDocumentation() {
		WebElement element = this.driver.findElement(By.cssSelector("a[href='/documentation/webdriver/']"));
		element.click();
		
		return new DocumentationPage(this.driver);
	}

	public HomePage navigate() {
		this.driver.navigate().to(homeUrl);
		
		return this;
	}
}