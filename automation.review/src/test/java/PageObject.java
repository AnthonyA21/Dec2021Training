import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	private WebDriver driver;

	public PageObject (WebDriver driver) {
		this.driver = driver;
	}

	protected WebDriver getDriver() {
		return this.driver;
	}
	
	protected void doNothing() {
		//does nothing
	}
	
	protected void doNothing(int someNumber) {
		//does nothing
	}
	
	protected void doNothing(String someString) {
		//does nothing
	}		

}
