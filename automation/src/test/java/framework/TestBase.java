package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class TestBase {

	private WebDriver driver;
	
	private void launchChromeDriver() {
		
		long pageLoadTimeout = 60;
		this.driver.manage().timeouts().implicitlyWait(pageLoadTimeout , TimeUnit.SECONDS);
	}
}